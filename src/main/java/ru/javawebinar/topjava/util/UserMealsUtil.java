package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        //getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();

        List<UserMealWithExceed> relevantMeal = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
        relevantMeal.forEach(userMealWithExceed -> System.out.println(userMealWithExceed.toString()));
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with correctly exceeded field

        Map<LocalDate, Integer> userCaloriesPerDay = new HashMap<>();
        Map<LocalDate, Booleanizer> isExceededDay = new HashMap<>();
        List<UserMealWithExceed> relevantMeal = new ArrayList<>();
        UserMealWithExceed relevantUserMealWithExceed = null;
        Booleanizer trueFalse;

        for (UserMeal meal: mealList)
        {
            Boolean exceed;
            LocalTime mealLocalTime = meal.getDateTime().toLocalTime();
            LocalDate date = meal.getDateTime().toLocalDate();
            trueFalse = new Booleanizer(meal.getCalories() > caloriesPerDay);

            isExceededDay.putIfAbsent(date, trueFalse);

            //если есть такой день в мапе, то добавляем к нему новых калорий, если нет такого дня - создаём пару день-калории

            int summCalories = userCaloriesPerDay.merge(date, meal.getCalories(), (oldvalue, newValue) -> oldvalue + newValue);

            //передаём в мапу обновлённое значение exceed и обновляем значение объекта Boolean

            if ((summCalories > caloriesPerDay))
            {
                isExceededDay.get(date).setTrueFalse(true);
            }

            if (TimeUtil.isBetween(mealLocalTime, startTime, endTime))
            {
                relevantUserMealWithExceed = new UserMealWithExceed(meal.getDateTime(),
                                                                    meal.getDescription(),
                                                                    meal.getCalories(),
                                                                    isExceededDay.get(date));
                relevantMeal.add(relevantUserMealWithExceed);
            }

        }
        return relevantMeal;
    }

}
