package org.example.constants;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static  int ISLAND_SIZE=5;
    public static  int TIME_FOR_GROW=3;
    private static final Map<String, Map<String,Integer>> PROBABILITIES_TO_EAT=new HashMap<>();

    private static final Map<String,Double> MIN_WEIGHT=new HashMap<>();

    private static final Map<String,Double> PROBABILITIES_TO_REPRODUCE=new HashMap<>();

    public static  int DAYS_WITHOUT_FOOD=6;

    public static int CONDITION=1;
    static {
        loadFromFile("src/main/resources/probabilities_for_eating.json",PROBABILITIES_TO_EAT);
        loadFromFile("src/main/resources/min_weight.json",MIN_WEIGHT);
        loadFromFile("src/main/resources/probabilities_for_reproduce.json",PROBABILITIES_TO_REPRODUCE);
    }

    private static <T>void loadFromFile(String filePath,Map<String,T> map) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, T> data = mapper.readValue(new File(filePath), Map.class);
            map.putAll(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getEatProbability(String predator, String prey) {
        return PROBABILITIES_TO_EAT.getOrDefault(predator, new HashMap<>()).getOrDefault(prey, 0);
    }
    public static double getMinWeight(String animal) {
        return MIN_WEIGHT.getOrDefault(animal, 0.0);
    }

    public static double getReproduceProbability(String animal)
    {
        return PROBABILITIES_TO_REPRODUCE.getOrDefault(animal,0.0);
    }

    public static void setIslandSize(int islandSize) {
        ISLAND_SIZE = islandSize;
    }

    public static void setTimeForGrow(int timeForGrow) {
        TIME_FOR_GROW = timeForGrow;
    }

    public static void setDaysWithoutFood(int daysWithoutFood) {
        DAYS_WITHOUT_FOOD = daysWithoutFood;
    }

    public static void setCONDITION(int CONDITION) {
        Constants.CONDITION = CONDITION;
    }
}
