package uk.co.mruoc.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import uk.co.mruoc.json.jackson.JsonNodeConverter;
import uk.co.mruoc.json.jackson.JsonParserConverter;

import java.util.Collection;

public class ExampleObjectDeserializer extends StdDeserializer<ExampleObject> {

    private static final Class<OtherExampleObject> OTHER_OBJECT_TYPE = OtherExampleObject.class;
    private static final TypeReference<Collection<OtherExampleObject>> OTHER_OBJECT_COLLECTION_TYPE = new TypeReference<Collection<OtherExampleObject>>() {
        // intentionally blank
    };

    public ExampleObjectDeserializer() {
        super(ExampleObject.class);
    }

    @Override
    public ExampleObject deserialize(JsonParser parser, DeserializationContext context) {
        JsonNode node = JsonParserConverter.toNode(parser);
        return ExampleObject.builder()
                .string(node.get("string").asText())
                .numeric(node.get("numeric").decimalValue())
                .stringArray(JsonNodeConverter.toStringCollection(node.get("stringArray"), parser))
                .numericArray(JsonNodeConverter.toBigDecimalCollection(node.get("numericArray"), parser))
                .other(JsonNodeConverter.toObject(node.get("other"), parser, OTHER_OBJECT_TYPE))
                .otherArray(JsonNodeConverter.toCollection(node.get("otherArray"), parser, OTHER_OBJECT_COLLECTION_TYPE))
                .build();
    }

}
