package org.example.fieladMechanics;

import org.example.Animals.Duck;
import org.example.commonTools.Tickable;
import org.example.nature.Landscape;

import java.util.ArrayList;
import java.util.List;

public class Cell implements Tickable {
    private final Landscape landscape;
    private List<Duck> animals = new ArrayList<>();
    private List<Duck> animalsTransfer = new ArrayList<>();
    int eatQuantity;
    public final Cordinate position;
    private static int RstaticCounter = 0;
    private int counter = 0;

    public Cell(Landscape landscape, Cordinate position) {
        this.landscape = landscape;
        this.position = position;
        eatQuantity = Field.globalRandom.nextInt(Field.MAX_EAT_BY_CELL);
        RstaticCounter++;
        counter = RstaticCounter;
    }

    public void addingDuckToCell(Duck duck) {
        animals.add(duck);
    }

    @Override
    public void tick() {
        animalsTransfer = new ArrayList<>();
        System.out.println("In tick coordinate method, cell pos X: " + position.getX() + ", pos Y: " + position.getY());
        System.out.println("duck size: " + animals.size());
        for (int i = 0; i < animals.size(); i++) {
            Duck duck = animals.get(i);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++After tic: " + duck);
            if (position.getX() == duck.getPosition().getX()
                    && position.getY() == duck.getPosition().getY()) continue;

            animalsTransfer.add(animals.remove(i));
            i--;
        }
    }

    public List<Duck> getAnimalsTransfer() {
        return animalsTransfer;
    }

    public List<Duck> getAnimals() {
        return animals;
    }
}
