package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;
import org.example.entities.abstracts.Animal;

public class Horse extends Herbivore {
    public Horse( Coordinate coordinates) {
        super("Лошадь", "\uD83D\uDC0E", coordinates, 400, 20, 4, 60);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Horse(coordinates);
    }
}
