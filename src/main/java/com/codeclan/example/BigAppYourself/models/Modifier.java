package com.codeclan.example.BigAppYourself.models;

import java.util.Random;

public enum Modifier {
    TOTALLY("totally"),
    COMPLETELY("completely"),
    UTTERLY("utterly"),
    PURE("pure"),
    BLANK(""),
    REALLY("really"),
    BLANK2(""),
    BLANK3(""),
    SO("so"),
    BLANK4("");

    private final String modifierValue;

    Modifier(String modifierValue){
        this.modifierValue = modifierValue;
    }

    public String getModifierValueFromEnum(){
        return this.modifierValue;
    }

    public static Modifier getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
