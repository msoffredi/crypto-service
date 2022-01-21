package org.soffredi.resources;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.soffredi.api.AvgAndDev;
import org.soffredi.api.MyNumber;
import org.soffredi.core.Calculator;

public class PushAndRecalculateResourceTest {
    final static private double NUM = 4d;
    final static private PushAndRecalculateResource resource = new PushAndRecalculateResource();
    
    @Test
    public void runsSuccessfully() {
        final AvgAndDev avgAndDev = resource.run(new MyNumber(NUM));
        final Calculator calculator = Calculator.getInstance();

        /**
         * Here we compare against the calculator since the execution order is not 
         * guaranteed and the output is stateful. However, we are not testing the
         * calculator itself but the resource, so this should be ok.
         */
        assertThat(avgAndDev.getAvg()).isEqualTo(calculator.getMean());
        assertThat(avgAndDev.getStdDev()).isEqualTo(calculator.getStdDev());
    }
}
