package org.example.Animals;

import org.example.fieladMechanics.Cordinate;

import java.util.Random;

public interface MovementStrategy {
    Cordinate makeStep(Random random, Cordinate currentPos);
}
