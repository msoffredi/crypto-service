package org.soffredi.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AvgAndDev {
    private double avg;
    private double dev;

    public AvgAndDev() {
    }

    public AvgAndDev(double avg, double dev) {
        this.avg = avg;
        this.dev = dev;
    }

    @JsonProperty
    public double getAvg() {
        return avg;
    }

    @JsonProperty
    public double getDev() {
        return dev;
    }
}
