package org.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HealthTrackerApp {
    private static UserManager userManager;
    private static DataManager dataManager;
    private static HealthAnalyzer analyzer;

    public static void main(String[] args) throws IOException {
        userManager = new UserManager();
        dataManager = new DataManager();
        analyzer = new HealthAnalyzer(dataManager);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Health Tracker System!");

        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Login");
            System.out.println("3. Enter Calorie Intake");
            System.out.println("4. Log Exercise");
            System.out.println("5. Log Sleep");
            System.out.println("6. View Caloric Balance");
            System.out.println("7. View Exercise Log");
            System.out.println("8. View Sleep Analysis");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    if (userManager.createUser(username)) {
                        System.out.println("User created successfully!");
                    } else {
                        System.out.println("Username already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    if (userManager.loginUser(username)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Username not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter food item: ");
                    String foodItem = scanner.nextLine();
                    System.out.print("Enter calories: ");
                    int calories = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    CalorieIntake intake = new CalorieIntake(new Date(), foodItem, calories);
                    dataManager.saveCalorieIntake(intake);
                    System.out.println("Calorie intake logged.");
                    break;

                case 4:
                    System.out.print("Enter exercise type: ");
                    String exerciseType = scanner.nextLine();
                    System.out.print("Enter duration (minutes): ");
                    int duration = scanner.nextInt();
                    System.out.print("Enter calories burned: ");
                    int caloriesBurned = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    ExerciseActivity activity = new ExerciseActivity(new Date(), exerciseType, duration, caloriesBurned);
                    dataManager.saveExerciseActivity(activity);
                    System.out.println("Exercise activity logged.");
                    break;

                case 5:
                    System.out.print("Enter hours of sleep: ");
                    int hours = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    SleepRecord sleep = new SleepRecord(new Date(), hours);
                    dataManager.saveSleepRecord(sleep);
                    System.out.println("Sleep record logged.");
                    break;

                case 6:
                    analyzer.calculateDailyCaloricBalance();
                    break;

                case 7:
                    analyzer.displayExerciseLog();
                    break;

                case 8:
                    analyzer.displaySleepAnalysis();
                    break;

                case 9:
                    System.out.println("Exiting. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
