package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Field {
    public static final int MAX_LIMIT_X = 100;
    public static final int MAX_LIMIT_Y = 20;
    public static final int MIN_LIMIT_X = 1;
    public static final int MIN_LIMIT_Y = 1;

    public static final Random globalRandom  = new Random();
    public static final Map<Cordinate, Square> coordinatePlane = generateWorld();

    public static final Map<Cordinate, Square> generateWorld() {
        Landscape[] landscapes = Landscape.values();
        Map<Cordinate, Square> squareMap = new HashMap<>();
        System.out.println("Generating world");

        for (int i = MIN_LIMIT_X; i <= MAX_LIMIT_X; i++) {
            for (int j = MIN_LIMIT_Y; j <= MAX_LIMIT_Y; j++) {
                Landscape landscape = landscapes[globalRandom.nextInt(landscapes.length)];
                squareMap.put(new Cordinate(i, j), new Square(landscape));
            }
        }
        System.out.println("World has been generated");
        return squareMap;
    }
}
