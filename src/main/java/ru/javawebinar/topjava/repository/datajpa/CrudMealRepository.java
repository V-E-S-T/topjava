package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;


@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {


    @Transactional
    Meal save(Meal meal, int userId);

    @Override
    @Transactional
    Meal save(Meal meal);

    @Modifying
    @Transactional
    @Query("DELETE FROM Meal m WHERE m.id=:id AND m.user.id=:userId ")
    int delete(@Param("id") int id, @Param("userId") int userId);


    @Transactional
    Meal findByIdAndUserId(int id, int userId);

    @Transactional
    List<Meal> getAllByUserId(int id);

    @Transactional
    List<Meal> getMealsByDateTimeBetweenAndUser_Id(LocalDateTime startDate, LocalDateTime endDate, int userId);
}
