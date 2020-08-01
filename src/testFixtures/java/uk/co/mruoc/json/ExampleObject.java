package uk.co.mruoc.json;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

@Builder
@Data
public class ExampleObject {

    private final String string;
    private final BigDecimal numeric;
    private final Collection<String> stringArray;
    private final Collection<BigDecimal> numericArray;
    private final String optional;
    private final OtherExampleObject other;

    public Optional<String> getOptional() {
        return Optional.ofNullable(optional);
    }

}
