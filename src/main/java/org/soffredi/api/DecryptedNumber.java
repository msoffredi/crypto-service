package org.soffredi.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DecryptedNumber {
    private double number;

    public DecryptedNumber() {
    }

    public DecryptedNumber(double number) {
        this.number = number;
    }

    @JsonProperty
    public double getNumber() {
        return number;
    }

    @JsonProperty
    public void setNumber(double number) {
        this.number = number;
    }
}
