package uk.co.mruoc.json;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JsonConversionExceptionTest {

    @Test
    void shouldReturnCause() {
        Throwable cause = new Exception();

        Throwable error = new JsonConversionException(cause);

        assertThat(error.getCause()).isEqualTo(cause);
    }

}
