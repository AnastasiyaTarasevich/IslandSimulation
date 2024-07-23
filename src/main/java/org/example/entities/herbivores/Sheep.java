package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;

public class Sheep extends Herbivore {
    public Sheep( Coordinate coordinates) {
        super("Овца", "\uD83D\uDC11", coordinates, 70, 140, 3, 15);
    }
}
