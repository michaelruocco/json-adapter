package uk.co.mruoc.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import org.junit.jupiter.api.Test;
import uk.co.mruoc.json.JsonConversionException;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class JacksonJsonConverterTest {

    private final ObjectMapper mapper = mock(ObjectMapper.class);

    private final JacksonJsonConverter converter = new JacksonJsonConverter(mapper);

    @Test
    void shouldThrowExceptionIfObjectConversionFails() throws JsonProcessingException {
        Object object = new Object();
        given(mapper.writeValueAsString(object)).willThrow(JsonProcessingException.class);

        Throwable error = catchThrowable(() -> converter.toJson(object));

        assertThat(error)
                .isInstanceOf(JsonConversionException.class)
                .hasCauseInstanceOf(JsonProcessingException.class);
    }

    @Test
    void shouldThrowExceptionIfJsonStringConversionToObjectFails() throws IOException {
        String json = "json";
        given(mapper.readValue(json, Object.class)).willThrow(JsonProcessingException.class);

        Throwable error = catchThrowable(() -> converter.toObject(json, Object.class));

        assertThat(error)
                .isInstanceOf(JsonConversionException.class)
                .hasCauseInstanceOf(JsonProcessingException.class);
    }

    @Test
    void shouldConvertObjectToJsonString() throws JsonProcessingException {
        Object object = new Object();
        String expectedJson = "json";
        given(mapper.writeValueAsString(object)).willReturn(expectedJson);

        String json = converter.toJson(object);

        assertThat(json).isEqualTo(expectedJson);
    }

    @Test
    void shouldConvertJsonStringToObject() throws IOException {
        String json = "json";
        Object expectedObject = new Object();
        given(mapper.readValue(json, Object.class)).willReturn(expectedObject);

        Object object = converter.toObject(json, Object.class);

        assertThat(object).isEqualTo(expectedObject);
    }

    @Test
    void shouldConvertJsonStringToJsonNode() throws IOException {
        String json = "json";
        JsonNode expectedNode = new TextNode("test");
        given(mapper.readTree(json)).willReturn(expectedNode);

        JsonNode node = converter.toJsonNode(json);

        assertThat(node).isEqualTo(expectedNode);
    }

    @Test
    void shouldThrowExceptionIfJsonStringConversionToJsonNodeFails() throws IOException {
        String json = "json";
        given(mapper.readTree(json)).willThrow(JsonProcessingException.class);

        Throwable error = catchThrowable(() -> converter.toJsonNode(json));

        assertThat(error)
                .isInstanceOf(JsonConversionException.class)
                .hasCauseInstanceOf(JsonProcessingException.class);
    }
}
