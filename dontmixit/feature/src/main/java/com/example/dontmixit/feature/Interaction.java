package com.example.dontmixit.feature;

public class Interaction {

    final Drug d1;
    final Drug d2;
    final String description;

    Interaction(Drug d1, Drug d2, String description) {
        this.d1 = d1;
        this.d2 = d2;
        this.description = description;
    }

    boolean contains(Drug test) {
        return d1 == test || d2 == test;
    }

    boolean matches(Drug t1, Drug t2) {
        return (d1 == t1 && d2 == t2) ||
               (d1 == t2 && d2 == t1);

    }



}
