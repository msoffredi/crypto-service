package org.soffredi.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EncryptedNumber {
    @NotNull
    private String encryptedNumber;

    public EncryptedNumber() {
    }
    
    public EncryptedNumber(String encryptedNumber) {
        this.encryptedNumber = encryptedNumber;
    }

    @JsonProperty
    public String getEncryptedNumber() {
        return this.encryptedNumber;
    }

    @JsonProperty
    public void setEncryptedNumber(String encryptedNumber) {
        this.encryptedNumber = encryptedNumber;
    }    
}
