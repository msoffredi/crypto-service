package org.soffredi.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EncryptedAvgAndDev {
    private String encryptedAvg;
    private String encryptedStdDev;

    public EncryptedAvgAndDev() {
    }

    public EncryptedAvgAndDev(String avg, String stdDev) {
        this.encryptedAvg = avg;
        this.encryptedStdDev = stdDev;
    }

    @JsonProperty
    public String getEncryptedAvg() {
        return encryptedAvg;
    }

    @JsonProperty
    public String getEncryptedStdDev() {
        return encryptedStdDev;
    }
}
