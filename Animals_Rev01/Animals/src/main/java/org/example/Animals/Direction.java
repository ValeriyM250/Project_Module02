package org.example.Animals;

import org.example.fieladMechanics.Cordinate;

public enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    UP_LEFT(-1, 1 ),
    UP_RIGHT(1, 1),
    DOWN_LEFT(-1, -1),
    DOWN_RIGHT(1 , -1),
    STAY(0, 0);

    final int dx;
    final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    Cordinate apply (Cordinate cordinate) {
        return new Cordinate(cordinate.getX() + dx, cordinate.getY() + dy);
    }
}
