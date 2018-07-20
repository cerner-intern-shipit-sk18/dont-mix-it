package com.example.dontmixit.feature;

public class Interaction {

    private final Drug d1;
    private final Drug d2;
    final String description;

    Interaction(Drug d1, Drug d2, String description) {
        this.d1 = d1;
        this.d2 = d2;
        this.description = description;
    }

    boolean contains(Drug test) {
        return d1 == test || d2 == test;
    }



}
