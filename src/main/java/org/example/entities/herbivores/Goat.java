package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;

public class Goat extends Herbivore {
    public Goat( Coordinate coordinates) {
        super("Коза", "\uD83D\uDC10", coordinates, 60, 140, 3, 15);
    }
}
