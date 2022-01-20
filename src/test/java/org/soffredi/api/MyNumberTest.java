package org.soffredi.api;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import io.dropwizard.jackson.Jackson;

public class MyNumberTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    private static final String DEC_NUM_JSON = "fixtures/MyNumber.json";
    private static final double NUMBER = 123d;

    @Test
    public void serializesToJSON() throws Exception {
        final MyNumber myNumber = new MyNumber(NUMBER);
        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture(DEC_NUM_JSON), MyNumber.class));
        assertThat(MAPPER.writeValueAsString(myNumber)).isEqualTo(expected);
    }
    
    @Test
    public void deserializesFromJSON() throws Exception {
        final MyNumber myNumber = new MyNumber(NUMBER);
        assertThat(
            MAPPER.readValue(fixture(DEC_NUM_JSON), MyNumber.class).getNumber()
        ).isEqualTo(myNumber.getNumber());
    }
}
