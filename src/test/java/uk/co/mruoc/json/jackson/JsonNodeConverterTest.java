package uk.co.mruoc.json.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UncheckedIOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class JsonNodeConverterTest {

    @Test
    void toObjectShouldThrowUncheckedIOExceptionIfJacksonThrowsIOException() throws IOException {
        ObjectCodec codec = mock(ObjectCodec.class);
        JsonParser parser = givenParserWithCodec(codec);
        JsonNode node = givenNodeFrom(codec, parser);
        Class<Object> type = Object.class;
        given(parser.readValueAs(type)).willThrow(IOException.class);

        Throwable error = catchThrowable(() -> JsonNodeConverter.toObject(node, parser, type));

        assertThat(error)
                .isInstanceOf(UncheckedIOException.class)
                .hasCauseInstanceOf(IOException.class);
    }

    @Test
    void toCollectionShouldThrowUncheckedIOExceptionIfJacksonThrowsIOException() throws IOException {
        ObjectCodec codec = mock(ObjectCodec.class);
        JsonParser parser = givenParserWithCodec(codec);
        JsonNode node = givenNodeFrom(codec, parser);
        TypeReference<?> type = mock(TypeReference.class);
        given(parser.readValueAs(type)).willThrow(IOException.class);

        Throwable error = catchThrowable(() -> JsonNodeConverter.toCollection(node, parser, type));

        assertThat(error)
                .isInstanceOf(UncheckedIOException.class)
                .hasCauseInstanceOf(IOException.class);
    }

    private JsonParser givenParserWithCodec(ObjectCodec codec) {
        JsonParser parser = mock(JsonParser.class);
        given(parser.getCodec()).willReturn(codec);
        return parser;
    }

    private JsonNode givenNodeFrom(ObjectCodec codec, JsonParser parser) {
        JsonNode node = mock(JsonNode.class);
        given(node.traverse(codec)).willReturn(parser);
        return node;
    }

}
