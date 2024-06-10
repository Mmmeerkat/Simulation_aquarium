package com.aquarium.action;

import com.aquarium.mapmodel.MapWorld;
import com.aquarium.entity.*;

import java.util.Arrays;
import java.util.List;

public class InitActions extends Actions{


    @Override
    public void action(MapWorld mapWorld) {
        this.mapWorld = mapWorld;
            initHerbivore();
            initGrass();
            initRoadBlock();
            initPredator();
    }
    public void initHerbivore(){
        for (int j = 0; j < (int)(Math.random()* MAX_COUNT + MIN_COUNT); j++){
            mapWorld.setupDefaultPositions(new Herbivore(1, 10));
        }
    }
    public void initPredator(){
        for (int j = 0; j < (int)(Math.random()* MAX_COUNT + MIN_COUNT); j++) {
            mapWorld.setupDefaultPositions(new Predator(1,10,5));
        }
    }
    public void initGrass() {
        for (int j = 0; j < (int) (Math.random() * mapWorld.x + mapWorld.y ); j++) {
            mapWorld.setupDefaultPositions(new Grass());

        }
    }
    public void initRoadBlock(){
        for (int j = 0; j < (int)(Math.random()* mapWorld.x + mapWorld.y); j++) {
            mapWorld.setupDefaultPositions(new Coral());
            mapWorld.setupDefaultPositions(new Rock());
            mapWorld.setupDefaultPositions(new Shell());

        }
        }


}
