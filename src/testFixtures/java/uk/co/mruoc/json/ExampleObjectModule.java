package uk.co.mruoc.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class ExampleObjectModule extends SimpleModule {

    public ExampleObjectModule() {
        super("example-object-module", Version.unknownVersion());
        addDeserializer(ExampleObject.class, new ExampleObjectDeserializer());
        addDeserializer(OtherExampleObject.class, new OtherExampleObjectDeserializer());
    }

}
