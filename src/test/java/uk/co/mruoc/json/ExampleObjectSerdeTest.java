package uk.co.mruoc.json;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;

public class ExampleObjectSerdeTest {

    private static final JsonConverter CONVERTER = new DefaultJsonConverterFactory(new ExampleObjectModule()).build();

    @ParameterizedTest(name = "should serialize example object {1}")
    @ArgumentsSource(ExampleObjectArgumentsProvider.class)
    void shouldSerialize(String expectedJson, ExampleObject example) {
        String json = CONVERTER.toJson(example);

        assertThatJson(json).isEqualTo(expectedJson);
    }

    @ParameterizedTest(name = "should deserialize example object {1}")
    @ArgumentsSource(ExampleObjectArgumentsProvider.class)
    void shouldDeserialize(String json, ExampleObject expectedExample) {
        ExampleObject example = CONVERTER.toObject(json, ExampleObject.class);

        assertThat(example).isEqualTo(expectedExample);
    }

    public static class ExampleObjectArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(ExampleObjectMother.buildJson(), ExampleObjectMother.build())
            );
        }

    }

}
