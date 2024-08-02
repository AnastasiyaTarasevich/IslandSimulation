package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;
import org.example.entities.abstracts.Animal;

public class Rabbit extends Herbivore {
    public Rabbit( Coordinate coordinates) {
        super("Кролик", "\uD83D\uDC07", coordinates, 2, 150, 2, 0.45);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Rabbit(coordinates);
    }
}
