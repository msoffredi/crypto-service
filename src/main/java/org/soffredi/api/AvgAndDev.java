package org.soffredi.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvgAndDev {
    private double avg;
    private double stdDev;

    public AvgAndDev() {
    }

    public AvgAndDev(double avg, double stdDev) {
        this.avg = avg;
        this.stdDev = stdDev;
    }

    @JsonProperty
    public double getAvg() {
        return avg;
    }

    @JsonProperty
    public double getStdDev() {
        return stdDev;
    }
}
