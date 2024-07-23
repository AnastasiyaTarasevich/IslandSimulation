package org.example.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cell {
    private List<Animal> animals;
    private List<Plant> plants;

    public Cell() {
        animals = new ArrayList<>();
        plants = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    @Override
    public String toString() {
        Map<String, Integer> animalCountMap = new HashMap<>();
        Map<String, Integer> plantCountMap = new HashMap<>();

        for (Animal animal : animals) {
            animalCountMap.put(animal.unicode, animalCountMap.getOrDefault(animal.unicode, 0) + 1);
        }

        for (Plant plant : plants) {
            plantCountMap.put(plant.getUnicode(), plantCountMap.getOrDefault(plant.getUnicode(), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : animalCountMap.entrySet()) {
            sb.append(entry.getKey()).append("(").append(entry.getValue()).append(") ");
        }

        for (Map.Entry<String, Integer> entry : plantCountMap.entrySet()) {
            sb.append(entry.getKey()).append("(").append(entry.getValue()).append(") ");
        }

        return sb.toString();
    }
}
