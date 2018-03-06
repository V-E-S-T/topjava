package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealDAO implements DAOInterfase{


    private static final transient AtomicInteger NEXT_ID = new AtomicInteger(0);
    private static final ConcurrentHashMap<Integer, Meal> DAOmapa  = new ConcurrentHashMap<>();

    static{
        DAOmapa.put(NEXT_ID.incrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 28, 10, 0), "Завтрак", 500, NEXT_ID.get()));
        DAOmapa.put(NEXT_ID.incrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 28, 13, 0), "Обед", 1000, NEXT_ID.get()));
        DAOmapa.put(NEXT_ID.incrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 28, 20, 0), "Ужин", 500, NEXT_ID.get()));
        DAOmapa.put(NEXT_ID.incrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 29, 10, 0), "Завтрак", 1000, NEXT_ID.get()));
        DAOmapa.put(NEXT_ID.incrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 29, 13, 0), "Обед", 500, NEXT_ID.get()));
        DAOmapa.put(NEXT_ID.incrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 29, 20, 0), "Ужин", 510, NEXT_ID.get()));
        DAOmapa.put(NEXT_ID.incrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 100, NEXT_ID.get()));
        DAOmapa.put(NEXT_ID.incrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000, NEXT_ID.get()));
        DAOmapa.put(NEXT_ID.incrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 30, 14, 0), "Обед", 1500, NEXT_ID.get()));
        DAOmapa.put(NEXT_ID.incrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 31, 9, 0), "Завтрак", 500, NEXT_ID.get()));
        DAOmapa.put(NEXT_ID.incrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000, NEXT_ID.get()));
        DAOmapa.put(NEXT_ID.incrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 31, 21, 0), "Ужин", 300, NEXT_ID.get()));

    }

    @Override
    public boolean addMeal(Meal meal)
    {
        if (meal != null)
        {
            DAOmapa.put(NEXT_ID.incrementAndGet(), meal);
            return true;
        }
        return false;
    }

    @Override
    public List<Meal> getMealList()
    {
        return Collections.list(DAOmapa.elements());
    }

    @Override
    public Meal create(LocalDateTime dateTime, String description, int calories)
    {
        return new Meal(dateTime, description, calories);
    }

    @Override
    public boolean update(LocalDateTime dateTime, String description, int calories, int id)
    {
        for (Meal meal: meals)
        {
            if (meal.getId() == id)
            {

            }
                return meals.remove(meal);
        }
        return false;
    }

    @Override
    public boolean delete(int id)
    {
        for (Meal meal: meals)
        {
            if (meal.getId() == id)
                return meals.remove(meal);
        }
        return false;
    }

    @Override
    public Meal read(int id) {

        for (Meal meal: meals)
        {
            if (meal.getId() == id)
                return meal;
        }
        return null;
    }
}
