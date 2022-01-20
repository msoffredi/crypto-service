package org.soffredi.core;

import javax.validation.constraints.NotNull;

public class InputEncryptedNumber {
    @NotNull
    private String encryptedNumber;

    public InputEncryptedNumber() {
    }
    
    public InputEncryptedNumber(String encryptedNumber) {
        this.encryptedNumber = encryptedNumber;
    }

    public String getEncryptedNumber() {
        return this.encryptedNumber;
    }

    public void setEncryptedNumber(String encryptedNumber) {
        this.encryptedNumber = encryptedNumber;
    }    
}
