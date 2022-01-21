package org.soffredi.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void calculatesAvgAndStdDev() {
        final Calculator calculator = Calculator.getInstance();
        
        // Initial state
        assertThat(calculator.getMean()).isEqualTo(0d);
        assertThat(calculator.getStdDev()).isEqualTo(0d);

        // First push
        calculator.push(4);
        assertThat(calculator.getMean()).isEqualTo(4d);
        assertThat(calculator.getStdDev()).isEqualTo(0d);

        // Second push
        calculator.push(6);
        assertThat(calculator.getMean()).isEqualTo(5d);
        assertThat(calculator.getStdDev()).isEqualTo(1d);

        /**
         * Thread-safe Calculator instance + push
         * Pushing 8 should result in { 6, ~1.632993161855452 }
         */ 
        final Calculator newCalculator = Calculator.getInstance();
        newCalculator.push(8);
        assertThat(calculator.getMean()).isEqualTo(6d);
        assertThat(
            String.format("%.6f", calculator.getStdDev())
        ).isEqualTo("1.632993");
    }
}
