package com.aquarium.pathsearch;

import com.aquarium.mapmodel.CellCoordinates;
import com.aquarium.mapmodel.MapWorld;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Astar {
    private final MapWorld mapWorld;
    private final HashMap newWorld;
    private final CellCoordinates start;
    private final CellCoordinates end;
    private static final int COST_DIRECT = 10;
    private static final int COST_DIAGONAL = 14;


    public Astar(MapWorld mapWorld, HashMap newMap,  CellCoordinates start, CellCoordinates end) {
        this.mapWorld = mapWorld;
        this.newWorld = newMap;
        this.start = start;
        this.end = end;
    }

    public LinkedList<CellCoordinates> findWay() {
        PriorityQueue<CostCellAstar> queueList = new PriorityQueue<>();
        LinkedList<CellCoordinates> path = new LinkedList<>();
        LinkedList<CellCoordinates> neighbor = new LinkedList<>();

        path.add(start);
        CellCoordinates currentCell = path.poll();
        while (!currentCell.equals(end)) {
            neighbor.addAll(findNeighbors(currentCell));
            for(CellCoordinates coordinates : neighbor){
                queueList.add(new CostCellAstar(coordinates, calculateFullCost(coordinates)));
            }
                CostCellAstar tmp = queueList.poll();
                currentCell = new CellCoordinates(tmp.x, tmp.y);
                path.add(currentCell);
                queueList.clear();
                neighbor.clear();
                if (path.size() > 8){
                    break;
                }



        }
        return path;

    }

    private LinkedList<CellCoordinates> findNeighbors(CellCoordinates current) {
//        PriorityQueue<CostCellAstar> neighbors = new PriorityQueue<>();
        LinkedList<CellCoordinates> neighbors = new LinkedList<>();
        for (int i = current.y - 1; i < current.y + 2; i++) {
            for (int j = current.x - 1; j < current.x + 2; j++) {
                if(j == end.x && i == end.y){
                    neighbors.clear();
                    neighbors.add(new CellCoordinates(j, i));
                    return neighbors;
                }
//                else if ((i >= 0 && j >= 0) && (current.x != j || current.y != i) {
//                    neighbors.add(new CellCoordinates(j, i));
                else if (checkNeighbor(new CellCoordinates(j, i))  && (current.x != j || current.y != i)){
                    neighbors.add(new CellCoordinates(j, i));
                }
            }
        }
        return neighbors;
    }

    private int calculateFullCost(CellCoordinates current) {
        if (end.x == current.x && end.y == current.y) {
            return 0;
        } else if (start.x != current.x && start.y != current.y) {
            return mapWorld.countPath(end, current)*COST_DIRECT + COST_DIAGONAL;
        } else {
            return mapWorld.countPath(end,current)*COST_DIRECT + COST_DIRECT;
        }
    }
//    public int countPath(CellCoordinates end, CellCoordinates current){
//        return (Math.abs(end.x - current.x) + Math.abs(end.y - current.y)) * COST_DIRECT;
//    }
    private boolean checkNeighbor(CellCoordinates cell){
        if(cell.x < 0 || cell.y < 0 && cell.x > mapWorld.x || cell.y > mapWorld.y){
            return false;
        }
        else if(!(newWorld.get(cell) == null && mapWorld.isWorldEmpty(cell))){
            return false;
        }
        return true;
    }
}