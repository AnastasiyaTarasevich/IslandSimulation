package org.example.entities.abstracts;

public abstract class Plant {
    protected String name;
    protected String unicode;
    protected double weight;
    protected int maxNumber_onCell;

    public Plant(String name, String unicode, double weight, int maxNumber_onCell) {
        this.name = name;
        this.unicode = unicode;
        this.weight = weight;
        this.maxNumber_onCell = maxNumber_onCell;
    }


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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMaxNumber_onCell() {
        return maxNumber_onCell;
    }

    public void setMaxNumber_onCell(int maxNumber_onCell) {
        this.maxNumber_onCell = maxNumber_onCell;
    }
}
