package org.example.initializer;

import org.example.constants.Constants;
import org.example.entities.Animal;
import org.example.entities.Coordinate;
import org.example.entities.Plant;
import org.example.entities.herbivores.*;
import org.example.entities.island.Island;
import org.example.entities.plants.Grass;
import org.example.entities.predators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class IslandInitializer {
    private int size;
    private Island island;
    private static IslandInitializer instance;
    private List<Animal> animalTypes;
    private List<Plant> plantTypes;

    private int days=0;
    public static synchronized IslandInitializer getInstance(int size) {
        if (instance == null) {
            instance = new IslandInitializer(size);
        }
        return instance;
    }
    private IslandInitializer(int size) {
        this.size = size;
        this.island = new Island(size);
        this.animalTypes = new ArrayList<>();
        this.plantTypes = new ArrayList<>();

        initializeAnimals();
        populateIsland();
    }

    private void initializeAnimals() {

        animalTypes.add(new Wolf(new Coordinate(0, 0)));
        animalTypes.add(new Boar(new Coordinate(0, 0)));
        animalTypes.add(new Deer(new Coordinate(0, 0)));
        animalTypes.add(new Duck(new Coordinate(0,0)));
        animalTypes.add(new Bear(new Coordinate(0,0)));
        animalTypes.add(new Buffalo(new Coordinate(0,0)));
        animalTypes.add(new Caterpillar(new Coordinate(0,0)));
        animalTypes.add(new Goat(new Coordinate(0,0)));
        animalTypes.add(new Horse(new Coordinate(0,0)));
        animalTypes.add(new Mouse(new Coordinate(0,0)));
        animalTypes.add(new Rabbit(new Coordinate(0,0)));
        animalTypes.add(new Sheep(new Coordinate(0,0)));
        animalTypes.add(new Eagle(new Coordinate(0,0)));
        animalTypes.add(new Fox(new Coordinate(0,0)));
        animalTypes.add(new Snake(new Coordinate(0,0)));
        plantTypes.add(new Grass());
    }

    private void populateIsland() {
        island.populate(animalTypes, plantTypes);
    }

    public void displayInitialIsland() {
        island.display();
    }

    public void displayIsland(int nTurns)
    {
        for (int i = 0; i < nTurns; i++) {
            days++;
            System.out.println("День "+(i+1)+"\n");
            if(days % Constants.TIME_FOR_GROW == 0)
            {
                addGrass();
            }
            island.performTurn();
            island.display();
            try {
                Thread.sleep(1000); // ожидание 1 секунду между днями
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void addGrass() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Plant grass=new Grass();
                island.getGrid(i,j).addPlant(grass);
            }
        }
    }
}
