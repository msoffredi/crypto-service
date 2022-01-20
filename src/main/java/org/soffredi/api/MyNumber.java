package org.soffredi.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyNumber {
    @NotNull
    private double number;

    public MyNumber() {
    }

    public MyNumber(double number) {
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
