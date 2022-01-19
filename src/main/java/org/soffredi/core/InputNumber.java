package org.soffredi.core;

import javax.validation.constraints.NotNull;

public class InputNumber {
    @NotNull
    private int number;

    public InputNumber() {
    }
    
    public InputNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
