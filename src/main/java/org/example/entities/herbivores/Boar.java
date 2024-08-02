package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;
import org.example.entities.abstracts.Animal;

public class Boar extends Herbivore {
    public Boar( Coordinate coordinates) {
        super("Кабан", "\uD83D\uDC17", coordinates, 400, 50, 2, 50);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Boar(coordinates);
    }
}
