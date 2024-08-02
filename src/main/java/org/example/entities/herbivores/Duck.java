package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;
import org.example.entities.abstracts.Animal;

public class Duck extends Herbivore {
    public Duck( Coordinate coordinates) {
        super("Утка", "\uD83E\uDD86", coordinates, 1, 200, 4, 0.15);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Duck(coordinates);
    }
}
