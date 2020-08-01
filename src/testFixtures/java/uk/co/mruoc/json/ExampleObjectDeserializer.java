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
        JsonNode node = JsonParserConverter.toNode(parser);
        return ExampleObject.builder()
                .string(node.get("string").asText())
                .numeric(node.get("numeric").decimalValue())
                .stringArray(JsonNodeConverter.toCollection(node.get("stringArray"), parser))
                .numericArray(JsonNodeConverter.toCollection(node.get("numericArray"), parser))
                .other(JsonNodeConverter.toObject(node.get("other"), parser, OtherExampleObject.class))
                .build();
    }

}
