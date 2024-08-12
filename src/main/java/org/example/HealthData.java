package org.example;

import java.util.Date;

abstract class HealthData {
    protected Date date;

    public HealthData(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}

class CalorieIntake extends HealthData {
    private String foodItem;
    private int calories;

    public CalorieIntake(Date date, String foodItem, int calories) {
        super(date);
        this.foodItem = foodItem;
        this.calories = calories;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return date + ": " + foodItem + " - " + calories + " calories";
    }
}

class ExerciseActivity extends HealthData {
    private String exerciseType;
    private int duration; // in minutes
    private int caloriesBurned;

    public ExerciseActivity(Date date, String exerciseType, int duration, int caloriesBurned) {
        super(date);
        this.exerciseType = exerciseType;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    @Override
    public String toString() {
        return date + ": " + exerciseType + " - " + duration + " mins - " + caloriesBurned + " calories burned";
    }
}

class SleepRecord extends HealthData {
    private int hoursOfSleep;

    public SleepRecord(Date date, int hoursOfSleep) {
        super(date);
        this.hoursOfSleep = hoursOfSleep;
    }

    public int getHoursOfSleep() {
        return hoursOfSleep;
    }

    @Override
    public String toString() {
        return date + ": " + hoursOfSleep + " hours of sleep";
    }
}
