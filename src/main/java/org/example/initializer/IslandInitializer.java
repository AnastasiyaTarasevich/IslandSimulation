package org.example.initializer;

import org.example.constants.Constants;
import org.example.entities.Herbivore;
import org.example.entities.Predator;
import org.example.entities.abstracts.Animal;
import org.example.entities.Coordinate;
import org.example.entities.abstracts.Plant;
import org.example.entities.herbivores.*;
import org.example.entities.island.Cell;
import org.example.entities.island.Island;
import org.example.entities.plants.Grass;
import org.example.entities.predators.*;
import org.example.statistics.Statistics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IslandInitializer {
    private int size;
    private Island island;
    private static IslandInitializer instance;
    private List<Animal> animalTypes;
    private List<Plant> plantTypes;
    private Statistics statistics=Statistics.getInstance();


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

    public void displayIsland()
    {
        int nTurns=0;
       while (!shouldStopSimulation()){
           nTurns++;
           System.out.println("\nДень "+nTurns+"\n");
            if(nTurns % Constants.TIME_FOR_GROW == 0)
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
        if(shouldStopSimulation())
        {
            System.out.println("\nСимуляция закончена из-за выполнения условий остановки\n");

        }

    }

    private void addGrass() {
        int count=0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Plant grass=new Grass();
                island.getGrid(i,j).addPlant(grass);
              count++;

            }
        }
        statistics.addGrownPlant(count);

    }

    private <T> int getIslandObjectCount(Class<T> tClass)
    {
        int count=0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell=island.getGrid(i,j);
                for(Object object: cell.getAnimals())
                {
                    if(tClass.isInstance(object))
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int getUniqueAnimalTypesCount()
    {
        Set<Class<? extends Animal>> uniqueSpecies=new HashSet<>();
        List<Animal> animals=island.getAllAnimals();
        for (Animal animal : animals) {
            uniqueSpecies.add(animal.getClass());
        }
        return uniqueSpecies.size();
    }


    public boolean shouldStopSimulation()
    {
        int herbivoreCount=getIslandObjectCount(Herbivore.class);
        int predatorCount=getIslandObjectCount(Predator.class);
        int uniqueTypes=getUniqueAnimalTypesCount();
        int condition=Constants.CONDITION;
        switch(condition)
        {
            case 1:
                return uniqueTypes==0;
            case 2:
                return herbivoreCount==0 && predatorCount>0;
            case 3:
                return uniqueTypes<=2;
            default:
                return false;
        }

    }

}
