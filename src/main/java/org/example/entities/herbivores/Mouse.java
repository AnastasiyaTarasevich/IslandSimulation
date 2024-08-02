package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;
import org.example.entities.abstracts.Animal;

public class Mouse extends Herbivore {
    public Mouse( Coordinate coordinates) {
        super("Мышь", "\uD83D\uDC01", coordinates, 0.05, 500, 1, 0.01);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Mouse(coordinates);
    }
}
