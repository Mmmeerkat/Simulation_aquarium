package com.aquarium.action;

import com.aquarium.mapmodel.MapWorld;


public abstract class Actions {

    public static final int MIN_COUNT = 5;
    public static final int MAX_COUNT = 15;
     MapWorld mapWorld;

    abstract public void action(MapWorld mapWorld);

}
