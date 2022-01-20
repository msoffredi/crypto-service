package org.soffredi.api;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import io.dropwizard.jackson.Jackson;

public class EncryptedAvgAndDevTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    private static final String ENC_AVG_DEV_JSON = "fixtures/encryptedAvgAndDev.json";

    // Mocked data since we are not testing encryption here, only representation
    private static final String AVG = "Encrypted_Avg";
    private static final String STD_DEV = "Encrypted_Std_Dev";

    @Test
    public void serializesToJSON() throws Exception {
        final EncryptedAvgAndDev encAvgAndDev = 
            new EncryptedAvgAndDev(AVG, STD_DEV);
        final String expected = 
            MAPPER.writeValueAsString(
                MAPPER.readValue(fixture(ENC_AVG_DEV_JSON), EncryptedAvgAndDev.class)
                );
        assertThat(MAPPER.writeValueAsString(encAvgAndDev)).isEqualTo(expected);
    }
}
