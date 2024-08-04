package org.example;


import org.example.initializer.IslandInitializer;
import org.example.menu.Menu;


public class Main {
    public static void main(String[] args) {
        Menu.printStarter();
        IslandInitializer app = IslandInitializer.getInstance(5);
        System.out.println("\nНачальное состояние острова\n");
        app.displayInitialIsland();
        app.displayIsland();
    }
}