package org.example.entities;

public class Predator extends Animal {
    public Predator(String name, String unicode, Coordinate coordinates, double weight, double maxNumber_onCell, int speed_of_movement, double sustenance) {
        super(name, unicode, coordinates, weight, maxNumber_onCell, speed_of_movement, sustenance);
    }

    @Override
    protected void move() {

    }

    @Override
    protected void eat() {

    }

    @Override
    protected void reproduce() {

    }
}
