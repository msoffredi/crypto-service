package org.soffredi.core;

import java.lang.Math;

/**
 * Incrementaly calculates the average and standard deviation of consecutive provided numbers.
 * This class is statful and thread safe.
 */
public class Calculator {
    private double mean = 0d;
    private double s = 0d;
    private int count = 0;

    private Calculator() {
    }
    
    private static class Singleton {
        private static final Calculator instance = new Calculator();
    }

    /**
     * Gets the only instance of the class since it's a singleton
     * 
     * @return a Calculator instance
     */
    public static Calculator getInstance() {
        return Singleton.instance;
    }

    /**
     * Gets the mean (average)
     * 
     * @return mean
     */
    public double getMean() {
        return mean;
    }

    private double getVariance() {
        return count == 0 ? 0 : s / count;
    }

    /**
     * Gets the standard deviation
     * 
     * @return standard deviation
     */
    public double getStdDev() {
        return Math.sqrt(getVariance());
    }

    /**
     * Pushes a new number into the calculations and updates both the mean (average) and
     * the variance (to calculate the standard deviation).
     * 
     * @param num new number
     */
    public void push(double num) {
        count++;
        final double delta = num - mean;
        mean = mean + delta / count;
        s += delta * (num - mean);
    }
}
