package org.soffredi.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.soffredi.core.AES;

public class EncryptedAvgAndDev {
    private String encryptedAvg;
    private String encryptedStdDev;
    private final String key = "abc123";

    public EncryptedAvgAndDev() {
    }

    public EncryptedAvgAndDev(double avg, double stdDev) {
        try {
            this.encryptedAvg = AES.encrypt(Double.toString(avg), key);
        } catch (Exception e) {
            this.encryptedAvg = "Encryption error";
        }

        try {
            this.encryptedStdDev = AES.encrypt(Double.toString(stdDev), key);
        } catch (Exception e) {
            this.encryptedStdDev = "Encryption error";
        }
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
