package uk.co.mruoc.json;

import java.math.BigDecimal;
import java.util.Arrays;

import static uk.co.mruoc.file.content.ContentLoader.loadContentFromClasspath;

public class ExampleObjectMother {

    private ExampleObjectMother() {
        // utility class
    }

    public static ExampleObject build() {
        return ExampleObject.builder()
                .string1("my-value-1")
                .numeric1(BigDecimal.valueOf(1.11))
                .stringArray(Arrays.asList("array1", "array2"))
                .numericArray(Arrays.asList(BigDecimal.valueOf(1.11), BigDecimal.valueOf(2.22)))
                .optional1(null)
                .build();
    }

    public static String buildJson() {
        return loadContentFromClasspath("json/example-object.json");
    }

}
