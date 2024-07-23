package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;

public class Duck extends Herbivore {
    public Duck( Coordinate coordinates) {
        super("Утка", "\uD83E\uDD86", coordinates, 1, 200, 4, 0.15);
    }
}
