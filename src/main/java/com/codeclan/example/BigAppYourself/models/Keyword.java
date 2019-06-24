package com.codeclan.example.BigAppYourself.models;

import com.sun.corba.se.impl.naming.cosnaming.InternalBindingKey;

import java.util.Random;

public enum Keyword {

    GENERAL(""),
    BEARD("is"),
    HAIR("is"),
    FACE("is"),
    BRAINS("are"),
    STARTUP("is"),
    EYES("are"),
    CHARM("is"),
    KINDNESS("is"),
    HUMANITY("is"),
    BIKE("is"),
    KNOWLEDGE("is"),
    FITNESS("is"),
    CODING("is"),
    COOKING("is"),
    DATABASE("is");

    private final String keywordTextFrag;

    Keyword(String keywordTextFrag){
        this.keywordTextFrag = keywordTextFrag;
    }

    public String getkeywordTextFragFromEnum(){
        return this.keywordTextFrag;
    }

    public static Keyword getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
