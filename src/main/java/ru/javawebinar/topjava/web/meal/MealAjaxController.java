package ru.javawebinar.topjava.web.meal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.DateTimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/ajax/meals")
public class MealAjaxController extends AbstractMealController {

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MealWithExceed> getAll() {
        return super.getAll();
    }

//    @Override
//    public List<MealWithExceed> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
//        return super.getBetween(startDate, startTime, endDate, endTime);
//    }

    @PostMapping
    public void createOrUpdate(//@RequestParam("id")int id,
                               @RequestParam("date")LocalDate date,
                               @RequestParam("time")LocalTime time,
                               @RequestParam("description")String description,
                               @RequestParam("calories")int calories) {

        Meal meal = new Meal(LocalDateTime.of(date, time), description, calories);

        if (meal.isNew())
        {
            super.create(meal);
        }
    }

}
