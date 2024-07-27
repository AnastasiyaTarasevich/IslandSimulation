package org.example.constants;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final int TIME_FOR_GROW=3;
    private static final Map<String, Map<String,Integer>> PROBABILITIES_TO_EAT=new HashMap<>();

    private static final Map<String,Double> MIN_WEIGHT=new HashMap<>();

    public static final int DAYS_WITHOUT_FOOD=3;
    static {
        loadFromFile("src/main/resources/probabilities_for_eating.json",PROBABILITIES_TO_EAT);
        loadFromFile("src/main/resources/min_weight.json",MIN_WEIGHT);
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
}
