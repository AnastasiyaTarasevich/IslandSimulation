package org.example.entities.predators;

import org.example.entities.Coordinate;
import org.example.entities.Predator;

public class Wolf extends Predator {
    public Wolf( Coordinate coordinates) {
        super("Волк", "\uD83D\uDC3A", coordinates, 50, 30, 3, 8);
    }
}
