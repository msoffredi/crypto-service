package org.soffredi.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Stores a number for input and output representation
 * (the name is on purpose to avoid the 'Number' class name)
 */
public class MyNumber {
    @NotNull
    private double number;

    public MyNumber() {
    }

    /**
     * Constructor
     * 
     * @param number number
     */
    public MyNumber(double number) {
        this.number = number;
    }

    /**
     * Gets the number
     * 
     * @return number
     */
    @JsonProperty
    public double getNumber() {
        return number;
    }

    /**
     * Sets the number
     * 
     * @param number number
     */
    @JsonProperty
    public void setNumber(double number) {
        this.number = number;
    }
}
