package org.example;


import org.example.initializer.IslandInitializer;



public class Main {
    public static void main(String[] args) {
        IslandInitializer app =IslandInitializer.getInstance(10);
        app.displayIsland();
    }
}