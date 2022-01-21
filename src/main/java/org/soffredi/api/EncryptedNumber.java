package org.soffredi.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Stores an encrypted number for input and output representation
 */
public class EncryptedNumber {
    @NotNull
    private String encryptedNumber;

    public EncryptedNumber() {
    }
    
    /**
     * Constructor
     * 
     * @param encryptedNumber encrypted number
     */
    public EncryptedNumber(String encryptedNumber) {
        this.encryptedNumber = encryptedNumber;
    }

    /**
     * Gets encrypted number
     * 
     * @return encrypted number
     */
    @JsonProperty
    public String getEncryptedNumber() {
        return this.encryptedNumber;
    }

    /**
     * Sets encrypted number
     * 
     * @param encryptedNumber encrypted number
     */
    @JsonProperty
    public void setEncryptedNumber(String encryptedNumber) {
        this.encryptedNumber = encryptedNumber;
    }    
}
