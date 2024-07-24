package org.example;


import org.example.initializer.IslandInitializer;



public class Main {
    public static void main(String[] args) {
        IslandInitializer app =IslandInitializer.getInstance(5);
        System.out.println("\nНачальное состояние острова\n");
        app.displayInitialIsland();
        app.displayIsland(5); // выполнение 5 ходов
    }
}