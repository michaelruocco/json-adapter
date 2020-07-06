package uk.co.mruoc.json;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

@Builder
@Data
public class ExampleObject {

    private final String string1;
    private final BigDecimal numeric1;
    private final Collection<String> stringArray;
    private final Collection<BigDecimal> numericArray;
    private final String optional1;

    public Optional<String> getOptional1() {
        return Optional.ofNullable(optional1);
    }

}
