package com.codeclan.example.BigAppYourself.models;

import java.util.ArrayList;
import java.util.List;

public class Keyword {

    private Long id;
    private String name;
    private String textfrag;
    private List<Superlative> superlatives;

    public Keyword(String name, String textfrag) {
        this.name = name;
        this.textfrag = textfrag;
        this.superlatives = new ArrayList<>();
    }

    public Keyword() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextfrag() {
        return textfrag;
    }

    public void setTextfrag(String textfrag) {
        this.textfrag = textfrag;
    }

    public List<Superlative> getSuperlatives() {
        return superlatives;
    }

    public void setSuperlatives(List<Superlative> superlatives) {
        this.superlatives = superlatives;
    }
}


