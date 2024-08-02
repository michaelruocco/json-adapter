package uk.co.mruoc.json;

import java.math.BigDecimal;
import java.util.Arrays;

import static uk.co.mruoc.file.FileLoader.loadContentFromClasspath;

public class ExampleObjectMother {

    private ExampleObjectMother() {
        // utility class
    }

    public static ExampleObject build() {
        return ExampleObject.builder()
                .string("my-value-1")
                .numeric(BigDecimal.valueOf(1.12))
                .stringArray(Arrays.asList("array1", "array2"))
                .numericArray(Arrays.asList(BigDecimal.valueOf(1.11), BigDecimal.valueOf(2.22)))
                .optional(null)
                .other(buildOther("my-other-value", BigDecimal.valueOf(3.33)))
                .otherArray(Arrays.asList(
                        buildOther("my-other-value-1", BigDecimal.valueOf(4.44)),
                        buildOther("my-other-value-2", BigDecimal.valueOf(5.55))
                ))
                .build();
    }

    public static String buildJson() {
        return loadContentFromClasspath("json/example-object.json");
    }

    private static OtherExampleObject buildOther(String stringValue, BigDecimal numericValue) {
        return OtherExampleObject.builder()
                .otherString(stringValue)
                .otherNumeric(numericValue)
                .build();
    }

}
