package uk.co.mruoc.json.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UncheckedIOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class JsonNodeConverterTest {

    @Test
    void shouldThrowUncheckedIOExceptionIfJacksonThrowsIOException() throws IOException {
        final JsonParser parser = mock(JsonParser.class);
        final ObjectCodec codec = mock(ObjectCodec.class);
        given(parser.getCodec()).willReturn(codec);
        final JsonNode node = mock(JsonNode.class);
        given(node.traverse(codec)).willReturn(parser);
        final Class<Object> type = Object.class;
        given(parser.readValueAs(type)).willThrow(IOException.class);

        final Throwable error = catchThrowable(() -> JsonNodeConverter.toObject(node, parser, type));

        assertThat(error)
                .isInstanceOf(UncheckedIOException.class)
                .hasCauseInstanceOf(IOException.class);
    }

}
