package com.aquarium.entity;


import com.aquarium.mapmodel.CellCoordinates;
import com.aquarium.mapmodel.MapWorld;
import com.aquarium.pathsearch.ListEntity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract public class Creature extends Entity {
    int speed;
    int healthPoints;

    abstract public PriorityQueue<ListEntity> makeMove(MapWorld mapWorld, HashMap hashMap);

    public Creature(int speed, int healthPoints) {
        this.speed = speed;
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

}
