package org.example.fieladMechanics;

import org.example.Animals.Duck;
import org.example.commonTools.DuckGenerator;
import org.example.commonTools.Tickable;
import org.example.nature.Landscape;

import java.util.*;

public class Field implements Tickable {
    public static final int MAX_LIMIT_X = 2;
    public static final int MAX_LIMIT_Y = 2;
    public static final int MIN_LIMIT_X = 0;
    public static final int MIN_LIMIT_Y = 0;
    public static final Random globalRandom  = new Random();
    public static final int MAX_EAT_BY_CELL = 100;

    public static Map<Cordinate, Cell> coordinatePlane;
    public static List<Duck> tickableAnimals;

    public Field() {
        generateNewWorld();
    }

    public static final void generateNewWorld() {
        tickableAnimals = new ArrayList<>();
        coordinatePlane = new HashMap<>();
        Landscape[] landscapes = Landscape.values();
        new DuckGenerator().generateSomeDucks();

        System.out.println("Generating world");
        for (int i = MIN_LIMIT_X; i <= MAX_LIMIT_X; i++) {
            for (int j = MIN_LIMIT_Y; j <= MAX_LIMIT_Y; j++) {
                Landscape landscape = landscapes[globalRandom.nextInt(landscapes.length)];
                Cordinate cordinate = new Cordinate(i, j);
                coordinatePlane.put(cordinate, new Cell(landscape, cordinate));
            }
        }

        for (Duck duck : tickableAnimals) {
            coordinatePlane.get(duck.getPosition()).addingDuckToCell(duck);
        }
        System.out.println("World has been generated");
    }


    @Override
    public void tick() {
        for (Duck tickable : tickableAnimals) tickable.tick();
        for (Map.Entry<Cordinate, Cell> transferAnimals : coordinatePlane.entrySet()) {
            transferAnimals.getValue().tick();
            for (Duck duckList : transferAnimals.getValue().getAnimalsTransfer()) {
                coordinatePlane.get(duckList.getPosition()).addingDuckToCell(duckList);
            }
        }
    }

    public static boolean boundsCheck(Cordinate cordinate) {
        if (cordinate.getX() > MAX_LIMIT_X || cordinate.getX() < MIN_LIMIT_X) return false;
        if (cordinate.getY() > MAX_LIMIT_Y || cordinate.getY() < MIN_LIMIT_Y) return false;
        return true;
    }

    public static Cordinate randomizeStartPosition() {
        return new Cordinate(globalRandom.nextInt(MIN_LIMIT_X, MAX_LIMIT_X), globalRandom.nextInt(MIN_LIMIT_Y, MAX_LIMIT_Y));
    }

    public void probaTest() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " - Call tick");
            tick();
            System.out.println("Printed");
        }
    }
}
