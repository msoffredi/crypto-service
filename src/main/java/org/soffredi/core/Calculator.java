package org.soffredi.core;

import java.lang.Math;

public class Calculator {
    private double mean = 0d;
    private double s = 0d;
    private int count = 0;

    private Calculator() {
    }
    
    private static class Singleton {
        private static final Calculator instance = new Calculator();
    }

    public static Calculator getInstance() {
        return Singleton.instance;
    }

    public double getMean() {
        return mean;
    }

    private double getVariance() {
        return count == 0 ? 0 : s / count;
    }


    public double getStdDev() {
        return Math.sqrt(getVariance());
    }

    public void push(int num) {
        count++;
        final double delta = num - mean;
        mean = mean + delta / count;
        s += delta * (num - mean);
    }
}
