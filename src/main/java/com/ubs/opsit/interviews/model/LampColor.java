package com.ubs.opsit.interviews.model;

public enum LampColor {
    RED("R"),
    YELLOW("Y");

    private String colorSymbol;
    LampColor(String colorSymbol){
        this.colorSymbol = colorSymbol;
    }

    @Override
    public String toString() {
        return colorSymbol;
    }
}
