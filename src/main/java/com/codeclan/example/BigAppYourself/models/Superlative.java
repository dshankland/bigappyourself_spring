package com.codeclan.example.BigAppYourself.models;

import java.util.Random;

public enum Superlative {
    AMAZING("amazing!"),
    FABULOUS("fabulous!"),
    BEAUTIFUL("beautiful!"),
    OUTOFTHISWORLD("out of this world!"),
    WONDERFUL("wonderful!"),
    DELICIOUS("delicious!"),
    JOLLYGOOD("jolly good!"),
    GLOSSY("glossy!"),
    NICESHAPE("a nice shape!"),
    AWESOME("awesome!"),
    AWEINSPIRING("awe-inspiring!"),
//    SUCHANICEPERSON("such a nice person!"),
    BEESKNEES("the bees knees!"),
    GREAT("great!"),
    COOL("cool!"),
    SENSATIONAL("sensational!"),
    TREMENDOUS("tremendous!"),
    BREATHTAKING("breathtaking!"),
    ONANOTHERLEVEL("on another level!"),
    BEYONDCOMPARE("beyond compare!"),
    SECONDTONONE("second to none!"),
    MAKINGMEWEEP("making me weep with joy!"),
    THEWORLDSGREATEST("the world's greatest!"),
    BESTEVER("the best ever!"),
    BESTYET("the best yet!"),
    SOMETHINGELSE("something else"),
    NICE("nice"),
    THEBUSINESS("the business!");


    private final String superlativeValue;

    Superlative(String superlativeValue){
        this.superlativeValue = superlativeValue;
    }

    public String getSuperlativeValueFromEnum(){
        return this.superlativeValue;
    }

    public static Superlative getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
