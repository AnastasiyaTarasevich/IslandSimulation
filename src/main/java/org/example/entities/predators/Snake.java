package org.example.entities.predators;

import org.example.entities.Coordinate;
import org.example.entities.Predator;

public class Snake extends Predator {
    public Snake( Coordinate coordinates) {
        super("Змея", "\uD83D\uDC0D", coordinates, 15, 30, 1, 3);
    }
}
