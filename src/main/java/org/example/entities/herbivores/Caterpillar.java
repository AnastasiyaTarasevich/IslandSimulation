package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;
import org.example.entities.abstracts.Animal;

public class Caterpillar extends Herbivore {
    public Caterpillar( Coordinate coordinates) {
        super("Гусеница", "\uD83D\uDC1B", coordinates, 0.01, 1000, 0, 0);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Caterpillar(coordinates);
    }
}
