package uk.co.mruoc.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uk.co.mruoc.json.JsonConversionException;
import uk.co.mruoc.json.JsonConverter;

import java.io.IOException;

public class JacksonJsonConverter implements JsonConverter {

    private final ObjectMapper mapper;

    public JacksonJsonConverter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new JsonConversionException(e);
        }
    }

    @Override
    public <T> T toObject(String json, Class<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            throw new JsonConversionException(e);
        }
    }

}
