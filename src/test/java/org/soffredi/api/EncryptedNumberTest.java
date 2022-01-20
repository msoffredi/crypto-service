package org.soffredi.api;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import io.dropwizard.jackson.Jackson;

public class EncryptedNumberTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    private static final String ENCRYPTED_NUMBER_JSON = "fixtures/EncryptedNumber.json";
    private static final String ENCRYPTED_NUMBER = "W7+AeY5oqQgkfMYYPw6/FQ==";

    @Test
    public void deserializesFromJSON() throws Exception {
        final EncryptedNumber encryptedNumber = new EncryptedNumber(ENCRYPTED_NUMBER);
        assertThat(
            MAPPER.readValue(
                    fixture(ENCRYPTED_NUMBER_JSON),
                    EncryptedNumber.class).getEncryptedNumber()
            ).isEqualTo(encryptedNumber.getEncryptedNumber()
        );
    }
}
