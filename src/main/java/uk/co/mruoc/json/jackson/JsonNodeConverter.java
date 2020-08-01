package uk.co.mruoc.json.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Collection;

public class JsonNodeConverter {

    private JsonNodeConverter() {
        // utility class
    }

    public static <T> Collection<T> toCollection(JsonNode node, JsonParser parser) {
        try {
            TypeReference<Collection<T>> typeReference = new TypeReference<Collection<T>>() {
                // intentionally blank
            };
            return node.traverse(parser.getCodec()).readValueAs(typeReference);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static <T> T toObject(JsonNode node, JsonParser parser, Class<T> type) {
        try {
            return node.traverse(parser.getCodec()).readValueAs(type);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
