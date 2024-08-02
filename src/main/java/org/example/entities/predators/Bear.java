package org.example.entities.predators;

import org.example.entities.Coordinate;
import org.example.entities.Predator;
import org.example.entities.abstracts.Animal;

public class Bear extends Predator {
    public Bear( Coordinate coordinates) {
        super("Медведь","\uD83D\uDC3B" , coordinates, 500, 5, 2, 80);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Bear(coordinates);
    }
}
