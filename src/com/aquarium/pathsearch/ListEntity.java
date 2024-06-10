package com.aquarium.pathsearch;

import com.aquarium.mapmodel.CellCoordinates;

public class ListEntity implements Comparable<ListEntity>{
    private final CellCoordinates attacker;
    private final CellCoordinates victim;
    private final int path;

    public ListEntity(CellCoordinates attacker, CellCoordinates victim, int path) {
        this.attacker = attacker;
        this.victim = victim;
        this.path = path;
    }

    @Override
    public int compareTo(ListEntity o) {
        return this.path - o.path;
    }

    public CellCoordinates getAttacker() {
        return attacker;
    }

    public CellCoordinates getVictim() {
        return victim;
    }
}
