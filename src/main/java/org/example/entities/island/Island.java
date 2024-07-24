package org.example.entities.island;

import org.example.entities.Animal;
import org.example.entities.Coordinate;
import org.example.entities.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Island {

    private Cell[][] grid;
    private int size;

    public Island(int size) {
        this.size = size;
        grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void populate(List<Animal> animalTypes, List<Plant> plantTypes) {

        for (Plant plantType : plantTypes) {
            int maxPlants = plantType.getMaxNumber_onCell();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (ThreadLocalRandom.current().nextBoolean()) { // С вероятностью 50% клетка будет заселена травой
                        int plantCount = ThreadLocalRandom.current().nextInt(maxPlants + 1);
                        for (int k = 0; k < plantCount; k++) {
                            try {
                                Plant plantInstance = plantType.getClass().newInstance();
                                grid[i][j].addPlant(plantInstance);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        for (Animal animalType : animalTypes) {
            int maxAnimals = (int) animalType.getMaxNumber_onCell();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (ThreadLocalRandom.current().nextBoolean()) { // С вероятностью 50% клетка будет заселена животными
                        int animalCount = ThreadLocalRandom.current().nextInt(maxAnimals + 1);
                        for (int k = 0; k < animalCount; k++) {
                            try {
                                Coordinate coordinate = new Coordinate(i, j);
                                Animal animalInstance = animalType.getClass()
                                        .getDeclaredConstructor(Coordinate.class)
                                        .newInstance(coordinate);
                                grid[i][j].addAnimal(animalInstance);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public void display() {

        int maxCellWidth = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = grid[i][j];
                String cellContent = cell.toString();
                int cellWidth = cellContent.split("\n")[0].length();
                if (cellWidth > maxCellWidth) {
                    maxCellWidth = cellWidth;
                }
            }
        }
        maxCellWidth = Math.max(maxCellWidth, 5); // Минимальная ширина клетки

        // Верхняя граница
        System.out.print("+");
        for (int j = 0; j < size; j++) {
            System.out.print("-".repeat(maxCellWidth + 2));  // +2 для пробелов по краям
            if (j < size - 1) {
                System.out.print("+");
            }
        }
        System.out.println("+");

        // Содержимое и промежуточные границы
        for (int i = 0; i < size; i++) {
            int maxLines = getMaxLines(); // Получаем максимальное количество строк
            for (int lineIndex = 0; lineIndex < maxLines; lineIndex++) {
                for (int j = 0; j < size; j++) {
                    Cell cell = grid[i][j];
                    String[] lines = cell.toString().split("\n");
                    String lineContent = lineIndex < lines.length ? lines[lineIndex] : "";
                    System.out.print("|");
                    System.out.print(String.format("%-" + maxCellWidth + "s", lineContent));
                    System.out.print(" ");
                }
                System.out.println("|");
            }

            // Нижний горизонтальный разделитель
            System.out.print("+");
            for (int j = 0; j < size; j++) {
                System.out.print("-".repeat(maxCellWidth + 2));  // +2 для пробелов по краям
                if (j < size - 1) {
                    System.out.print("+");
                }
            }
            System.out.println("+");
        }
    }


    private int getMaxLines() {
        int maxLines = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = grid[i][j];
                String[] lines = cell.toString().split("\n");
                if (lines.length > maxLines) {
                    maxLines = lines.length;
                }
            }
        }
        return maxLines;
    }


    public int getSize() {
        return size;
    }


    public synchronized void performTurn() {
        List<Animal> allAnimals = getAllAnimals();
        allAnimals.parallelStream().forEach(animal -> {
            Coordinate oldCoord = animal.getCoordinates();
            animal.moveAnimal(this);

            Coordinate newCoord = animal.getCoordinates();

            synchronized (grid[oldCoord.getX()][oldCoord.getY()]) {
                grid[oldCoord.getX()][oldCoord.getY()].removeAnimal(animal);
            }

            if (newCoord.getX() >= 0 && newCoord.getX() < size && newCoord.getY() >= 0 && newCoord.getY() < size) {
                synchronized (grid[newCoord.getX()][newCoord.getY()]) {
                    grid[newCoord.getX()][newCoord.getY()].addAnimal(animal);
                }
            }
        });
    }

    private List<Animal> getAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                animals.addAll(grid[i][j].getAnimals());
            }
        }
        return animals;
    }

    public Cell getGrid(int x, int y) {
        return grid[x][y];
    }
}

