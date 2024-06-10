package com.aquarium;

import com.aquarium.action.InitActions;
import com.aquarium.action.TurnAction;
import com.aquarium.mapmodel.MapRender;
import com.aquarium.mapmodel.MapWorld;

import java.util.Scanner;

public class Simulation {

        public static void main(String[] args) {
            MapWorld mapWorld = new MapWorld(30, 20);

            MapRender mapRender = new MapRender();
            InitActions initActions = new InitActions();
            TurnAction turnAction = new TurnAction(mapWorld);

            Scanner scanner = new Scanner(System.in);
            printMenuGame();
            initActions.action(mapWorld);
            mapRender.render(mapWorld);
//            printMenuGame();
//            idSimulation = scanner.nextInt();
            for (int i = 0; i < 10; i++) {
                turnAction.action(mapWorld);
                mapRender.render(mapWorld);
                System.out.println("tyt");
                turnAction.action(mapWorld);
                mapRender.render(mapWorld);
                turnAction.action(mapWorld);
                mapRender.render(mapWorld);
            }



//            while (!(idSimulation == 3)) {
//                switch (idSimulation) {
//                    case (1):
//
//                        break;
//                    case (2):
//                        while (true) {
//                        }
//                    case (3):
//                        break;
//                }
//            }
        }
        public static void printMenuGame(){
            System.out.println("~~~~~~~~~~~~~~~~~Меню~~~~~~~~~~~~~~~~~");
            System.out.println("1~~~~~~~Симуляция~одного~хода~~~~~~~~~");
            System.out.println("2~~~Бесконечная~симуляция~аквариума~~~");
            System.out.println("3~~~~~~~~~~~~Закончить~игру~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

    }
