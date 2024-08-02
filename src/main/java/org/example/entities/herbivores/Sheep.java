package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;
import org.example.entities.abstracts.Animal;

public class Sheep extends Herbivore {
    public Sheep( Coordinate coordinates) {
        super("Овца", "\uD83D\uDC11", coordinates, 70, 140, 3, 15);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Sheep(coordinates);
    }
}
