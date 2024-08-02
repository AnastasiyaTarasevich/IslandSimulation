package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;
import org.example.entities.abstracts.Animal;

public class Goat extends Herbivore {
    public Goat( Coordinate coordinates) {
        super("Коза", "\uD83D\uDC10", coordinates, 60, 140, 3, 15);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Goat(coordinates);
    }
}
