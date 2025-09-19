package org.example;

import org.example.Animals.Duck;

import java.util.ArrayList;
import java.util.List;

public class Square implements Tickable{
    private final Landscape landscape;
    List<Duck> animals = new ArrayList<>();

    public Square(Landscape landscape) {
        this.landscape = landscape;
    }


}
