package org.example.entities.predators;

import org.example.entities.Coordinate;
import org.example.entities.Predator;
import org.example.entities.abstracts.Animal;

public class Fox extends Predator {
    public Fox( Coordinate coordinates) {
        super("Лиса", "\uD83E\uDD8A", coordinates, 8, 30, 2, 2);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Fox(coordinates);
    }
}
