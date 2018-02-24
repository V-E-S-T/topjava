package ru.javawebinar.topjava.model;

import ru.javawebinar.topjava.util.Booleanizer;

import java.time.LocalDateTime;

/**
 * GKislin
 * 11.01.2015.
 */
public class UserMealWithExceed {
    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private final Booleanizer exceed;

    public UserMealWithExceed(LocalDateTime dateTime, String description, int calories, Booleanizer exceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }

    @Override
    public String toString() {
        return ("dateTime: " + this.dateTime + "\n" +
                "description: " + this.description + "\n" +
                "calories: " + this.calories + "\n" +
                "exceed: " + this.exceed.isTrueFalse());
    }
}
