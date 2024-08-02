package org.example.entities.predators;

import org.example.entities.Coordinate;
import org.example.entities.Predator;
import org.example.entities.abstracts.Animal;

public class Wolf extends Predator {
    public Wolf( Coordinate coordinates) {
        super("Волк", "\uD83D\uDC3A", coordinates, 50, 30, 3, 8);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Wolf(coordinates);
    }
}
