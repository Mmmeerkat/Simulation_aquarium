package com.aquarium.pathsearch;

import com.aquarium.mapmodel.CellCoordinates;

import java.util.Objects;

public class CostCellAstar implements Comparable<CostCellAstar>{
    public final int cost;
    public final int x;
    public final int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostCellAstar that = (CostCellAstar) o;
        return cost == that.cost && x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, x, y);
    }

    public CostCellAstar(int cost, int x, int y) {
        this.cost = cost;
        this.x = x;
        this.y = y;
    }
    public CostCellAstar(int x, int y) {
        this.cost = 0;
        this.x = x;
        this.y = y;
    }
    public CostCellAstar(CellCoordinates coordinates, int cost) {
        this.cost = cost;
        this.x = coordinates.x;
        this.y = coordinates.y;
    }
    @Override
    public int compareTo(CostCellAstar o) {
        return this.cost - o.cost;
    }
}
