package org.example;

import java.io.IOException;
import java.util.*;

class HealthAnalyzer {
    private DataManager dataManager;

    public HealthAnalyzer(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void calculateDailyCaloricBalance() throws IOException {
        List<String> calories = dataManager.readFile("calories.txt");
        List<String> exercises = dataManager.readFile("exercise.txt");

        // Simplified analysis logic
        // Actual implementation would involve parsing dates and summing values per day
        System.out.println("Daily Caloric Balance:");
        for (String calorie : calories) {
            System.out.println(calorie);
        }
        for (String exercise : exercises) {
            System.out.println(exercise);
        }
    }

    public void displayExerciseLog() throws IOException {
        List<String> exercises = dataManager.readFile("exercise.txt");
        System.out.println("Exercise Log:");
        for (String exercise : exercises) {
            System.out.println(exercise);
        }
    }

    public void displaySleepAnalysis() throws IOException {
        List<String> sleeps = dataManager.readFile("sleep.txt");
        System.out.println("Sleep Analysis:");
        for (String sleep : sleeps) {
            System.out.println(sleep);
        }
    }
}
