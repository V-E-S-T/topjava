package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.dao.DAOInterfase;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public class MealDAOServiceImplements implements MealDAOServiceInterface{

    private DAOInterfase mealDAO;

    public MealDAOServiceImplements(DAOInterfase mealDAO) {
        this.mealDAO = mealDAO;
    }

//    @Override
//    public List<Meal> getMealList() {
//        return mealDAO.getMealList();
//    }

    @Override
    public Meal create(LocalDateTime dateTime, String description, int calories) {
        return mealDAO.create(dateTime, description, calories);
    }

    @Override
    public boolean update(LocalDateTime dateTime, String description, int calories, int id) {
        return mealDAO.update(dateTime, description, calories, id);
    }

    @Override
    public boolean delete(int id) {
        return mealDAO.delete(id);
    }

    @Override
    public Meal get(int id) {
        return mealDAO.get(id);
    }

    @Override
    public boolean addMeal(Meal meal) {
        return mealDAO.addMeal(meal);
    }
}
