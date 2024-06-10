package com.aquarium.entity;

import com.aquarium.action.InitActions;
import com.aquarium.pathsearch.Astar;
import com.aquarium.mapmodel.CellCoordinates;
import com.aquarium.mapmodel.MapWorld;
import com.aquarium.pathsearch.ListEntity;

import java.util.*;

public class Predator extends Creature {

    public final int attackPoint;
    public Predator(int speed, int healthPoints, int attackPoint) {
        super(speed, healthPoints);
        this.attackPoint = attackPoint;
    }

    @Override
    public String toString() {
        return "\uD83E\uDD88 ";
    } // 🦑

    @Override
    public PriorityQueue<ListEntity> makeMove(MapWorld mapWorld, HashMap hashMap) {
        PriorityQueue<ListEntity> listEntities = new PriorityQueue<>();
        Iterator<Map.Entry<CellCoordinates, Entity>> iterator = mapWorld.getHashMapWorld().entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<CellCoordinates, Entity> entry = iterator.next();
            if (entry.getValue() instanceof Herbivore herbivore) {
                if (hashMap.get(herbivore.getCoordinates()) != null) {
                    int path = mapWorld.countPath(herbivore.getCoordinates(), this.getCoordinates());
                    listEntities.add(new ListEntity(this.getCoordinates(), herbivore.getCoordinates(), path));
                }
            }
        }
        return listEntities;
    }


}
