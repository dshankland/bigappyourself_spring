package com.codeclan.example.BigAppYourself.controllers;

import com.codeclan.example.BigAppYourself.models.Keyword;
import com.codeclan.example.BigAppYourself.models.Superlative;
import com.sun.org.apache.xpath.internal.compiler.Keywords;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/keywords")
public class KeywordController {

    @GetMapping
    public List<Keyword> displayKeywords() {
        return Arrays.asList(Keyword.values());
    }

}
