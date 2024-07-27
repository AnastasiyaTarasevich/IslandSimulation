package org.example.entities;

import org.example.constants.Constants;
import org.example.entities.abstracts.Animal;
import org.example.entities.abstracts.Plant;
import org.example.entities.island.Cell;
import org.example.entities.island.Island;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Herbivore extends Animal {
    public Herbivore(String name, String unicode, Coordinate coordinates, double weight, double maxNumber_onCell, int speed_of_movement, double sustenance) {
        super(name, unicode, coordinates, weight, maxNumber_onCell, speed_of_movement, sustenance);
    }

    @Override
    public void eat(Island island) {
        Cell cell=island.getGrid(coordinates.getX(),coordinates.getY());
        List<Plant> plantsInCell;

        boolean hasEaten=false;
        synchronized (cell) {
            plantsInCell = new ArrayList<>(cell.getPlants());
        }
        if (!plantsInCell.isEmpty()) {
            for (Plant plant : plantsInCell) {

                int probability = Constants.getEatProbability(this.getName(), plant.getName());
                if (ThreadLocalRandom.current().nextInt(100) < probability) {
                    cell.removePlant(plant);
                    this.resetDaysWithoutFood();
                    this.foodConsumed+=plant.getWeight();
                   hasEaten=true;
                   if(this.foodConsumed>=this.sustenance)
                       break;
                }


            }
        }
        if(!hasEaten||this.foodConsumed<this.sustenance) {
            List<Animal> animalsInCell;
            synchronized (cell) {
                animalsInCell = new ArrayList<>(cell.getAnimals());
            }

            for (Animal animal : animalsInCell) {
                if (!animal.equals(this)) {
                    int probability = Constants.getEatProbability(this.getName(), animal.getName());
                    if (ThreadLocalRandom.current().nextInt(100) < probability) {
                        synchronized (cell) {
                            cell.removeAnimal(animal);
                            this.resetDaysWithoutFood();
                            this.foodConsumed+=animal.getWeight();
                            hasEaten=true;
                            if(this.foodConsumed>=this.sustenance)
                            {
                                break;
                            }
                        }

                    }
                }
            }
        }
        if (hasEaten) {
            this.resetDaysWithoutFood();
            this.weight++;
            this.foodConsumed = 0; // Сбросить количество потребленной пищи после еды
        } else {
            this.addDayWithoutFood();
        }
    }


    @Override
    protected void reproduce() {

    }
}
