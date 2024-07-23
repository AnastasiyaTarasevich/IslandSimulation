package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;

public class Rabbit extends Herbivore {
    public Rabbit( Coordinate coordinates) {
        super("Кролик", "\uD83D\uDC07", coordinates, 2, 150, 2, 0.45);
    }
}
