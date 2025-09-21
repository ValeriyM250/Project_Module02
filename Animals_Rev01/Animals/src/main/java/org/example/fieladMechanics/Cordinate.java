package org.example.fieladMechanics;

import java.util.Objects;

public class Cordinate {
    private final int x;
    private final int y;

    public Cordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
/// ////////// STD func /////////////////////////////
    @Override
    public int hashCode() {
        return 17 * x * 31 + y * 31;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cordinate))
            return false;
        Cordinate input = (Cordinate) o;
        return this.getX() == input.getX() && this.getY() == input.getY();
    }

    @Override
    public String toString() {
        return "Coordinate: X - " + x + ", Y - " + y;
    }
}
