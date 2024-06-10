package com.aquarium.entity;

import com.aquarium.mapmodel.CellCoordinates;

abstract public class Entity {
    private CellCoordinates coordinates;

    public CellCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CellCoordinates coordinates) {
        this.coordinates = coordinates;
    }

}
