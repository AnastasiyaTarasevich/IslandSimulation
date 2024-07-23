package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;

public class Buffalo extends Herbivore {
    public Buffalo( Coordinate coordinates) {
        super("Буйвол", "\uD83D\uDC03", coordinates, 700, 10, 3, 100);
    }
}
