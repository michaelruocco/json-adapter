package uk.co.mruoc.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uk.co.mruoc.json.jackson.JacksonJsonConverter;

import java.util.Arrays;
import java.util.Collection;

import static com.fasterxml.jackson.databind.DeserializationFeature.*;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

@RequiredArgsConstructor
@Slf4j
public class DefaultJsonConverterFactory implements JsonConverterFactory {

    private final Collection<Module> modules;

    public DefaultJsonConverterFactory(Module... modules) {
        this(Arrays.asList(modules));
    }

    @Override
    public JsonConverter build() {
        return new JacksonJsonConverter(customize(new ObjectMapper()));
    }

    private ObjectMapper customize(ObjectMapper mapper) {
        log.info("registering jackson modules {}", modules);
        return mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
                .disable(WRITE_DATES_AS_TIMESTAMPS)
                .enable(USE_BIG_DECIMAL_FOR_FLOATS)
                .registerModule(new Jdk8Module())
                .registerModules(modules);
    }

}
