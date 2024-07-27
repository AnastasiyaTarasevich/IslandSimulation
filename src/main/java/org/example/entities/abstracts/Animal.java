package org.example.entities.abstracts;

import org.example.constants.Constants;
import org.example.entities.Coordinate;
import org.example.entities.Herbivore;
import org.example.entities.island.Cell;
import org.example.entities.island.Island;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {

    protected String name;
    protected String unicode;
    protected Coordinate coordinates;
    protected double weight;

    protected double minWeight;
    protected double maxNumber_onCell;
    protected int speed_of_movement;

    protected double sustenance; //кг пищи для насыщения

    protected double foodConsumed;
    protected int daysWithoutFood;

    public Animal(String name, String unicode, Coordinate coordinates,
                  double weight, double maxNumber_onCell, int speed_of_movement, double sustenance) {
        this.name = name;
        this.unicode = unicode;
        this.coordinates = coordinates;
        this.weight = weight;
        this.maxNumber_onCell = maxNumber_onCell;
        this.speed_of_movement = speed_of_movement;
        this.sustenance = sustenance;
        this.foodConsumed = 0;
        this.daysWithoutFood=0;
    }


    protected synchronized void move(Island island) {
        int currentX = coordinates.getX();
        int currentY = coordinates.getY();
        int newX=Math.max(0,Math.min(island.getSize()-1, coordinates.getX()+ ThreadLocalRandom.current().nextInt(-speed_of_movement,speed_of_movement+1)));
        int newY=Math.max(0,Math.min(island.getSize()-1, coordinates.getY()+ThreadLocalRandom.current().nextInt(-speed_of_movement,speed_of_movement+1)));
        setCoordinates(new Coordinate(newX,newY));
    }
    public void moveAnimal(Island island) {
        move(island); // Вызов защищенного метода move через публичный метод
    }
    public  abstract void eat(Island island);

    protected abstract void reproduce();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnicode() {
        return unicode;
    }

    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMaxNumber_onCell() {
        return maxNumber_onCell;
    }

    public void setMaxNumber_onCell(double maxNumber_onCell) {
        this.maxNumber_onCell = maxNumber_onCell;
    }

    public int getSpeed_of_movement() {
        return speed_of_movement;
    }

    public void setSpeed_of_movement(int speed_of_movement) {
        this.speed_of_movement = speed_of_movement;
    }

    public double getSustenance() {
        return sustenance;
    }

    public void setSustenance(double sustenance) {
        this.sustenance = sustenance;
    }
    public void addDayWithoutFood()
    {
        this.daysWithoutFood++;
        this.weight-=this.weight*0.1;
    }
    public void resetFoodConsumed() {
        this.foodConsumed = 0;
    }
    public void resetDaysWithoutFood() {
        this.daysWithoutFood = 0;
    }
}