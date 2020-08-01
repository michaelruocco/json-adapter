package uk.co.mruoc.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import uk.co.mruoc.json.jackson.JsonParserConverter;

public class OtherExampleObjectDeserializer extends StdDeserializer<OtherExampleObject> {

    public OtherExampleObjectDeserializer() {
        super(OtherExampleObject.class);
    }

    @Override
    public OtherExampleObject deserialize(JsonParser parser, DeserializationContext context) {
        JsonNode node = JsonParserConverter.toNode(parser);
        return OtherExampleObject.builder()
                .otherString(node.get("otherString").asText())
                .otherNumeric(node.get("otherNumeric").decimalValue())
                .build();
    }

}
