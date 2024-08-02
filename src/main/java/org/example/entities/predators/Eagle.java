package org.example.entities.predators;

import org.example.entities.Coordinate;
import org.example.entities.Predator;
import org.example.entities.abstracts.Animal;

public class Eagle extends Predator {
    public Eagle( Coordinate coordinates) {
        super("Орел", "\uD83E\uDD85", coordinates, 6, 20, 3, 1);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Eagle(coordinates);
    }
}
