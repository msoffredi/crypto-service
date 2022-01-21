package org.soffredi.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Stores the average and standard deviation for output representation
 */
public class AvgAndDev {
    private double avg;
    private double stdDev;

    public AvgAndDev() {
    }

    /**
     * Constructor
     * 
     * @param avg average number
     * @param stdDev standard deviation number
     */
    public AvgAndDev(double avg, double stdDev) {
        this.avg = avg;
        this.stdDev = stdDev;
    }

    /**
     * Gets the average value as a double
     * 
     * @return average
     */
    @JsonProperty
    public double getAvg() {
        return avg;
    }

    /**
     * Gets the StandardDeviation value as a double
     * 
     * @return standard deviation
     */
    @JsonProperty
    public double getStdDev() {
        return stdDev;
    }
}
