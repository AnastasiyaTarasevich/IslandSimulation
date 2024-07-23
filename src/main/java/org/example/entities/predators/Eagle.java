package org.example.entities.predators;

import org.example.entities.Coordinate;
import org.example.entities.Predator;

public class Eagle extends Predator {
    public Eagle( Coordinate coordinates) {
        super("Орел", "\uD83E\uDD85", coordinates, 6, 20, 3, 1);
    }
}
