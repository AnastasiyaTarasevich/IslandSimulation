package org.example.entities;

import org.example.constants.Constants;
import org.example.entities.abstracts.Animal;
import org.example.entities.island.Cell;
import org.example.entities.island.Island;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    public Predator(String name, String unicode, Coordinate coordinates, double weight, double maxNumber_onCell, int speed_of_movement, double sustenance) {
        super(name, unicode, coordinates, weight, maxNumber_onCell, speed_of_movement, sustenance);
    }

    @Override
    public void eat(Island island) {
        Cell cell = island.getGrid(coordinates.getX(), coordinates.getY());
        List<Animal> animalsInCell;
        boolean hasEaten = false;
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
                        this.foodConsumed += animal.getWeight();
                        hasEaten = true;
                        if (this.foodConsumed >= this.sustenance) {
                            break;
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
    protected abstract Animal createNewAnimal(Coordinate coordinates);


}
