package uk.co.mruoc.json.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.util.Collection;

public class JsonNodeConverter {

    private static final TypeReference<Collection<String>> STRING_COLLECTION = new TypeReference<Collection<String>>() {
        // intentionally blank
    };

    private static final TypeReference<Collection<BigDecimal>> BIG_DECIMAL_COLLECTION = new TypeReference<Collection<BigDecimal>>() {
        // intentionally blank
    };

    private JsonNodeConverter() {
        // utility class
    }

    public static Collection<String> toStringCollection(JsonNode node, JsonParser parser) {
        return toCollection(node, parser, STRING_COLLECTION);
    }

    public static Collection<BigDecimal> toBigDecimalCollection(JsonNode node, JsonParser parser) {
        return toCollection(node, parser, BIG_DECIMAL_COLLECTION);
    }

    public static <T> T toCollection(JsonNode node, JsonParser parser, TypeReference<T> type) {
        try {
            return node.traverse(parser.getCodec()).readValueAs(type);
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
