package org.soffredi.api;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import io.dropwizard.jackson.Jackson;

public class AvgAndDevTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    private static final String AVG_AND_DEV_JSON = "fixtures/avgAndDev.json";
    private static final double AVG = 123d;
    private static final double STD_DEV = 234d;

    @Test
    public void serializesToJSON() throws Exception {
        final AvgAndDev avgAndDev = new AvgAndDev(AVG, STD_DEV);
        final String expected = 
            MAPPER.writeValueAsString(
                MAPPER.readValue(fixture(AVG_AND_DEV_JSON), AvgAndDev.class)
                );
        assertThat(MAPPER.writeValueAsString(avgAndDev)).isEqualTo(expected);
    }
}
