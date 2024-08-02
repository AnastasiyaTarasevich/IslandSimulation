package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;
import org.example.entities.abstracts.Animal;

public class Deer extends Herbivore {
    public Deer(Coordinate coordinates) {
        super("Олень", "\uD83E\uDD8C", coordinates, 300, 20, 4, 50);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Deer(coordinates);
    }
}
