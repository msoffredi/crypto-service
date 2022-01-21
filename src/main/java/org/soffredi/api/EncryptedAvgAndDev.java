package org.soffredi.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Stores the average and standard deviation as strings representing their encrypted
 * version for output representation.
 */
public class EncryptedAvgAndDev {
    private String encryptedAvg;
    private String encryptedStdDev;

    public EncryptedAvgAndDev() {
    }

    /**
     * Constructor
     * 
     * @param avg encrypted average
     * @param stdDev encrypted standard deviation
     */
    public EncryptedAvgAndDev(String avg, String stdDev) {
        this.encryptedAvg = avg;
        this.encryptedStdDev = stdDev;
    }

    /**
     * Gets the encrypted average
     * 
     * @return encrypted average
     */
    @JsonProperty
    public String getEncryptedAvg() {
        return encryptedAvg;
    }

    /**
     * Gets encrypted standard deviation
     * 
     * @return encrypted standard deviation
     */
    @JsonProperty
    public String getEncryptedStdDev() {
        return encryptedStdDev;
    }
}
