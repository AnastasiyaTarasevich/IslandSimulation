package org.example.constants;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final int TIME_FOR_GROW=3;
    private static final Map<String, Map<String,Integer>> PROBABILITIES_TO_EAT=new HashMap<>();

    public static final int DAYS_WITHOUT_FOOD=3;
    static {
        loadProbabilitiesFromFile("src/main/resources/probabilities_for_eating.json");
    }

    private static void loadProbabilitiesFromFile(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Map<String, Integer>> data = mapper.readValue(new File(filePath), Map.class);
            PROBABILITIES_TO_EAT.putAll(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getEatProbability(String predator, String prey) {
        return PROBABILITIES_TO_EAT.getOrDefault(predator, new HashMap<>()).getOrDefault(prey, 0);
    }
}
