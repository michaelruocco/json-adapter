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

public class JsonParserConverterTest {

    @Test
    void shouldConvertParserToNode() throws IOException {
        JsonParser parser = mock(JsonParser.class);
        ObjectCodec codec = mock(ObjectCodec.class);
        given(parser.getCodec()).willReturn(codec);
        JsonNode expectedNode = mock(JsonNode.class);
        given(codec.readTree(parser)).willReturn(expectedNode);

        JsonNode node = JsonParserConverter.toNode(parser);

        assertThat(node).isEqualTo(expectedNode);
    }

    @Test
    void shouldThrowUncheckedIOExceptionIfJacksonThrowsIOException() throws IOException {
        JsonParser parser = mock(JsonParser.class);
        ObjectCodec codec = mock(ObjectCodec.class);
        given(parser.getCodec()).willReturn(codec);
        given(codec.readTree(parser)).willThrow(IOException.class);

        Throwable error = catchThrowable(() -> JsonParserConverter.toNode(parser));

        assertThat(error)
                .isInstanceOf(UncheckedIOException.class)
                .hasCauseInstanceOf(IOException.class);
    }

}
