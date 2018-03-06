package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface DAOInterfase {

    public List<Meal> getMealList();


    public Meal create(LocalDateTime dateTime, String description, int calories);


    public boolean update(LocalDateTime dateTime, String description, int calories, int id);


    public boolean delete(int id);

    public Meal read(int id);

    public boolean addMeal(Meal meal);

}

