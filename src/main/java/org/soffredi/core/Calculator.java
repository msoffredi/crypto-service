package org.soffredi.core;

public class Calculator {
    private double avg = 0d;
    private int count = 0;

    private Calculator() {
    }
    
    private static class Singleton {
        private static final Calculator instance = new Calculator();
    }

    public static Calculator getInstance() {
        return Singleton.instance;
    }

    public double getAvg() {
        return avg;
    }

    public void push(int num) {
        avg = ((avg * count) + num) / ++count;
    }
}
