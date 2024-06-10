package com.aquarium.mapmodel;

import java.util.Objects;

public class CellCoordinates  {
    public final int x; // почему не просто инт? ширина
    public final int y; // высота

    @Override
    public String toString() {

        return "{ " +
                "х = " + x +
                ", у = " + y +
                '}';
    }

    public CellCoordinates(int width, int height) {
        this.x = width; // ширина
        this.y = height; // высота
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellCoordinates that = (CellCoordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


}
