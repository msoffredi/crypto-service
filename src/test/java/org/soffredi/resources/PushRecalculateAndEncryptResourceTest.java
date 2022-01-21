package org.soffredi.resources;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.soffredi.api.EncryptedAvgAndDev;
import org.soffredi.api.MyNumber;
import org.soffredi.core.AES;
import org.soffredi.core.Calculator;

public class PushRecalculateAndEncryptResourceTest {
    final static private double NUM = 4d;
    final static private String KEY = "abc123";
    final static private PushRecalculateAndEncryptResource resource =
            new PushRecalculateAndEncryptResource(KEY);

    @Test
    public void runsSuccessfully() throws Exception {
        final EncryptedAvgAndDev encAvgAndDev = resource.run(new MyNumber(NUM));
        final Calculator calculator = Calculator.getInstance();
        
        /**
         * Here we compare against the calculator since the execution order is not 
         * guaranteed and the output is stateful. However, we are not testing the
         * calculator itself but the resource, so this should be ok.
         */
        assertThat(encAvgAndDev.getEncryptedAvg())
            .isEqualTo(AES.encrypt(Double.toString(calculator.getMean()), KEY));
        assertThat(encAvgAndDev.getEncryptedStdDev())
            .isEqualTo(AES.encrypt(Double.toString(calculator.getStdDev()), KEY));
    }
}
