package org.example.Animals;

import org.example.Cordinate;
import org.example.Field;
import org.example.Tickable;

public class Duck implements Tickable, MovementStrategy {
    private final double MAX_WEIGH = 12.0;
    private final double MIN_WEIGH = 9.0;
    private final int MAX_STEP_QUANTITY = 3;

    boolean hasEat;
    private Cordinate position;
    double weigh;

    public Duck(Cordinate position, double weigh, int stepQuantity) {
        this.position = position;
        this.weigh = weigh;
    }

    public Cordinate getPosition() {
        return position;
    }

    private void getHungry() {
        weigh = weigh - weigh * 0.5;
        if (weigh <= MIN_WEIGH) dying();
    }

    private void eating() {
        weigh = weigh - weigh + 0.5;

    }

    private void dying() {
        position = new Cordinate(-1, -1);
    }

    @Override
    public Cordinate makeStep() {

    }

    @Override
    public void tick() {
        if (hasEat) eating();
        else getHungry();
    }
}
