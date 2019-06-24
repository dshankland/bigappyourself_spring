package com.codeclan.example.BigAppYourself.models;

import java.util.Random;

public enum Modifier {
    TOTALLY("totally"),
    COMPLETELY("completely"),
    UTTERLY("utterly"),
    PURE("pure"),
    REALLY("really"),
    SO("so"),
    ULTRA("ultra"),
    SUPER("super"),
    ABSOLUTELY("absolutely"),
    UBER("uber"),
    SOSO("so, so"),
    SOSOSO("so, so, so"),
    SUPREMELY("supremely"),
    SUPERBLY("superbly"),
    INDISPUTABLY("indisputably"),
    UNDOUBTEDLY("undoubtedly"),
    FANTASTICALLY("fantastically"),
    DEAD("dead"),
    MEGA("mega");

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
