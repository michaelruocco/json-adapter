package uk.co.mruoc.json;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class OtherExampleObject {

    private final String otherString;
    private final BigDecimal otherNumeric;

}
