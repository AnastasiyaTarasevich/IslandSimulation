package org.example.entities.herbivores;

import org.example.entities.Coordinate;
import org.example.entities.Herbivore;
import org.example.entities.abstracts.Animal;

public class Buffalo extends Herbivore {
    public Buffalo( Coordinate coordinates) {
        super("Буйвол", "\uD83D\uDC03", coordinates, 700, 10, 3, 100);
    }

    @Override
    protected Animal createNewAnimal(Coordinate coordinates) {
        return new Buffalo(coordinates);
    }
}
