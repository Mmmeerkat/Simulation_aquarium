package com.aquarium.action;

import com.aquarium.entity.*;
import com.aquarium.mapmodel.CellCoordinates;
import com.aquarium.mapmodel.MapWorld;
import com.aquarium.pathsearch.Astar;
import com.aquarium.pathsearch.ListEntity;

import java.util.*;

public class TurnAction extends Actions {
    HashMap<CellCoordinates, Entity> hashMap = new HashMap<>();

    public TurnAction(MapWorld mapWorld) {
        this.mapWorld = mapWorld;
    }

    @Override
    public void action(MapWorld mapWorld) {
        hashMap.clear();
        Set<Map.Entry<CellCoordinates, Entity>> entrys = mapWorld.getHashMapWorld().entrySet();
        fillStaticobject();
        for (Map.Entry<CellCoordinates, Entity> entry : entrys) {
            if (entry.getValue() instanceof Creature creature) {
                if (creature instanceof Herbivore){
                    findFood(creature);
                }

            }
        }
        for (Map.Entry<CellCoordinates, Entity> entry : entrys) {
            if (entry.getValue() instanceof Creature creature) {
                if (creature instanceof Predator){
                    findFood(creature);
                }
            }
        }
        mapWorld.changeMap(hashMap);
    }

    public void findFood(Creature creature) {
        LinkedList<CellCoordinates> listEnity;
        PriorityQueue<ListEntity> listEntities = creature.makeMove(mapWorld, hashMap);
        if(listEntities.isEmpty()){
            System.out.println("закончилась еда");
            hashMap.put(creature.getCoordinates(), creature);
        }
        else {
            Astar astar = new Astar(mapWorld, hashMap, listEntities.peek().getAttacker(), listEntities.peek().getVictim());
            listEnity = astar.findWay();
            System.out.print("объект переместился с " + creature.getCoordinates());
            creature.setCoordinates(listEnity.get(0));
            System.out.println(" -> " + listEnity.get(0));

            if (listEnity.size() <= 2 && mapWorld.countPath(listEnity.get(listEnity.size() - 1), listEnity.get(0)) <= 2) {
                System.out.println("Съели объект " + (listEnity.get(listEnity.size() - 1)));
                hashMap.remove(listEnity.get(listEnity.size() - 1));
            }
            hashMap.put(listEnity.get(0), creature);
        }
    }
    public void fillStaticobject(){
        Iterator<Map.Entry<CellCoordinates, Entity>> iterator = mapWorld.getHashMapWorld().entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<CellCoordinates, Entity> entry = iterator.next();
            if (!(entry.getValue() instanceof Creature)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
    }
}