package com.aquarium.mapmodel;


import com.aquarium.entity.Entity;
import com.aquarium.entity.Grass;
import com.aquarium.entity.Herbivore;
import com.aquarium.entity.Predator;
import com.aquarium.mapmodel.CellCoordinates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapWorld {
    public final int x;
    public final int y;

   private HashMap<CellCoordinates, Entity> hashMapWorld = new HashMap<>(); // не можем использовать примитивный тип для параметризации
 // Не нужно будет заполнять пустоты в структуре
// В джава для того, чтобы использовать в хэшмап свой класс в качестве ключа надо дописать иквелс и хэшкод для внутренней логики подсчета хэша

    public MapWorld(int x, int y) {
        this.x = x;
        this.y = y;
//        this.hashMapWorld = hashMapWorld;       , HashMap<Coordinates, Entity> hashMapWorld
    }

    public HashMap<CellCoordinates, Entity> getHashMapWorld() {
        return hashMapWorld;
    }

    public void setEntity(CellCoordinates coordinates, Entity entity) {
        hashMapWorld.put(coordinates, entity);


    }
//    public void getEntity(CellCoordinates coordinates, Entity entity) {
//        Set<CellCoordinates> keys = hashMapWorld.keySet();
//        hashMapWorld.get(coordinates);}



    public void removeEntity(CellCoordinates coordinates) {
//        entity.coordinates = coordinates;
        hashMapWorld.remove(coordinates);
    }
    public boolean isWorldEmpty(CellCoordinates coordinates){
        return !hashMapWorld.containsKey(coordinates);
    }
    public Entity getEntity(CellCoordinates coordinates){
        return hashMapWorld.get(coordinates);
    }

public void setupDefaultPositions(Entity entity) {
    CellCoordinates randomPlace = randomCoordinates();
    entity.setCoordinates(randomPlace);
        setEntity(randomPlace,entity);

}

     public CellCoordinates randomCoordinates(){
        CellCoordinates coordinates = new CellCoordinates((int)(Math.random() *x), (int)(Math.random() *y));
//         System.out.println(coordinates);
//        while (!isWorldEmpty(coordinates)){
////            System.out.println("!!"+ coordinates);
//            coordinates = randomCoordinates();
//        }
        return coordinates;
    }
    public int countPath(CellCoordinates end, CellCoordinates current){

        return (Math.abs(end.x - current.x) + Math.abs(end.y - current.y));
    }

    public boolean isGrass(Entity entity){
        return entity instanceof Grass;
    }
    public boolean isHerbivore(Entity entity){
        return entity instanceof Herbivore;
    }
    public boolean isPredator(Entity entity){
        return entity instanceof Predator;
    }

    public void changeMap(HashMap<CellCoordinates, Entity> newMapWorld){
        Set<Map.Entry<CellCoordinates, Entity>> newMap= newMapWorld.entrySet();
        hashMapWorld.clear();
        for(Map.Entry<CellCoordinates, Entity> objMap : newMap){
            hashMapWorld.put(objMap.getKey(), objMap.getValue());
        }

    }

}
