package com.aquarium.entity;

import com.aquarium.action.InitActions;
import com.aquarium.pathsearch.Astar;
import com.aquarium.mapmodel.CellCoordinates;
import com.aquarium.mapmodel.MapWorld;
import com.aquarium.pathsearch.ListEntity;

import java.util.*;

public class Herbivore extends Creature {


    public Herbivore(int speed, int healthPoints) {
        super(speed, healthPoints);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC20 ";
    }

    @Override
    public PriorityQueue<ListEntity> makeMove(MapWorld mapWorld, HashMap hashMap) {
        PriorityQueue<ListEntity> listEntities = new PriorityQueue<>();
        Iterator<Map.Entry<CellCoordinates, Entity>> iterator = mapWorld.getHashMapWorld().entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<CellCoordinates, Entity> entry = iterator.next();
            if (entry.getValue() instanceof Grass grass) {
                if (hashMap.get(grass.getCoordinates()) != null) {
                    int path = mapWorld.countPath(grass.getCoordinates(), this.getCoordinates());
                    listEntities.add(new ListEntity(this.getCoordinates(), grass.getCoordinates(), path));
                }
            }
        }
        return listEntities;
    }


}


