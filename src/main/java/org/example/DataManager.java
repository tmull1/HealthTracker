package org.example;

import java.io.*;
import java.util.*;

class DataManager {
    private static final String CALORIE_FILE = "calories.txt";
    private static final String EXERCISE_FILE = "exercise.txt";
    private static final String SLEEP_FILE = "sleep.txt";

    public DataManager() {
        createFileIfNotExists(CALORIE_FILE);
        createFileIfNotExists(EXERCISE_FILE);
        createFileIfNotExists(SLEEP_FILE);
    }

    private void createFileIfNotExists(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile(); // This will create an empty file if it doesn't exist
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + fileName);
            e.printStackTrace();
        }
    }

    public void saveCalorieIntake(CalorieIntake intake) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(CALORIE_FILE, true));
        writer.write(intake.toString());
        writer.newLine();
        writer.close();
    }

    public void saveExerciseActivity(ExerciseActivity activity) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(EXERCISE_FILE, true));
        writer.write(activity.toString());
        writer.newLine();
        writer.close();
    }

    public void saveSleepRecord(SleepRecord record) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(SLEEP_FILE, true));
        writer.write(record.toString());
        writer.newLine();
        writer.close();
    }

    public List<String> readFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
}
