package com.example.palindrome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PalindromeInput {
    private final String inputString;


    public PalindromeInput(@JsonProperty("PalindromeInput") String inputString) {
        this.inputString = inputString;
    }
    public String getInput(){
        return inputString;
    }
}
