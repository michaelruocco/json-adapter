package uk.co.mruoc.json.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

public class JsonNodeConverter {

    private JsonNodeConverter() {
        // utility class
    }

    public static Collection<BigDecimal> toBigDecimalCollection(final JsonNode node, final JsonParser parser) {
        return Arrays.asList(toObject(node, parser, BigDecimal[].class));
    }

    public static Collection<String> toStringCollection(final JsonNode node, final JsonParser parser) {
        return Arrays.asList(toObject(node, parser, String[].class));
    }

    public static <T> T toObject(final JsonNode node, final JsonParser parser, final Class<T> type) {
        try {
            return node.traverse(parser.getCodec()).readValueAs(type);
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
