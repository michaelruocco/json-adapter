package uk.co.mruoc.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import uk.co.mruoc.json.jackson.JsonNodeConverter;
import uk.co.mruoc.json.jackson.JsonParserConverter;

public class ExampleObjectDeserializer extends StdDeserializer<ExampleObject> {

    public ExampleObjectDeserializer() {
        super(ExampleObject.class);
    }

    @Override
    public ExampleObject deserialize(JsonParser parser, DeserializationContext context) {
        final JsonNode node = JsonParserConverter.toNode(parser);
        return ExampleObject.builder()
                .string1(node.get("string1").asText())
                .numeric1(node.get("numeric1").decimalValue())
                .stringArray(JsonNodeConverter.toStringCollection(node.get("stringArray"), parser))
                .numericArray(JsonNodeConverter.toBigDecimalCollection(node.get("numericArray"), parser))
                .build();
    }

}
