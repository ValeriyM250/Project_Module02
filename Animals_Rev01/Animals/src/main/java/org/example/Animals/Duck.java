package org.example.Animals;

import org.example.fieladMechanics.Cordinate;
import org.example.fieladMechanics.Field;
import org.example.commonTools.Tickable;
import java.util.Random;

public class Duck implements Tickable, Walkable {
    private final double MAX_WEIGH = 12.0;
    private final double MIN_WEIGH = 9.0;
    private final int DUCK_STEPS_QUANTITY = 3;
    private final double DAILY_WEIGHT_LOSS_PERCENT = 0.5;
    private final double ADDITION_WEGHT_AFTER_EATING = 0.5;
    private final double INITIAL_WEIGHT = 10;

    private static int id = 0;
    boolean isAlive;
    boolean hasEat;
    private Cordinate position;
    double weigh;

    public Duck(Cordinate position) {
        this.position = position;
        isAlive = true;
        id++;
        weigh = INITIAL_WEIGHT;
        Field.tickableAnimals.add(this);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Duck id: " + id + ", Curr Pos X: " + position.getX()
                + ", Y: " + position.getY();
    }

    public Cordinate getPosition() {
        return position;
    }

    private void getHungry() {
        weigh = weigh - weigh * DAILY_WEIGHT_LOSS_PERCENT;
        if (weigh <= MIN_WEIGH) dying();
    }

    private void eating() {
        weigh = weigh - weigh + ADDITION_WEGHT_AFTER_EATING;

    }

    private void dying() {
        isAlive = false;
    }

/// ////////////////////////////////////////////////////////////// helper methods
    @Override
    public void tick() {
        System.out.println("______________________________before tic: " + this);
        position = walk(position, DUCK_STEPS_QUANTITY);
        //if (hasEat) eating();
        //else getHungry();
    }


    @Override
    public Cordinate walk(Cordinate oldPos, int stepsQuantity) {
        Cordinate newPos = oldPos;
        for (int i = 0; i < stepsQuantity; i++) {
            newPos = makeStep(Field.globalRandom, newPos);
        }
        return newPos;
    }

    @Override
    public Cordinate makeStep(Random random, Cordinate currentPos) {                   //this method should be private
        Direction[] directions = Direction.values();
        boolean stepApply = false;
        Direction generated = null;
        while (!stepApply) {
            generated = directions[random.nextInt(directions.length)];
            stepApply = Field.boundsCheck(generated.apply(currentPos));
        }
        return generated.apply(currentPos);
    }
}
