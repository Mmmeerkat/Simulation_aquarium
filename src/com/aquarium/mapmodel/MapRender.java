package com.aquarium.mapmodel;

import com.aquarium.entity.Entity;

public class MapRender {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001b[48;5;17m";
    private static final String ANSI_CYAN = "\u001b[36m";


    public void render(MapWorld mapWorld){
        System.out.println(ANSI_CYAN + " =============================================");
        int i = 0;
        System.out.println("   0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 ");
        for (int height = 0; height < mapWorld.y; height++) {
            System.out.print(ANSI_CYAN+i++ +" " + ANSI_BLUE);
            for (int widht = 0; widht < mapWorld.x; widht++) {
                if(mapWorld.isWorldEmpty(new CellCoordinates(widht, height)))
                System.out.print(" ◦ ");
                else {
                    Entity entity =mapWorld.getEntity(new CellCoordinates(widht,height)); // long
                    System.out.print(entity);
                }
            }
            System.out.println( ANSI_RESET+ "  ");
        }
        System.out.println(ANSI_CYAN + " =============================================" + ANSI_RESET);
    }


}
