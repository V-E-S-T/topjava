package ru.javawebinar.topjava.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional(readOnly = true)
public class JpaMealRepositoryImpl implements MealRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Meal save(Meal meal, int userId) {

        if (meal.isNew())
        {
            em.persist(meal);
            return meal;
        }
        else
        {
            return em.merge(meal);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {

        return em.createNamedQuery(Meal.DELETE)
                .setParameter("id", id)
                //.setParameter("user_id", userId)
                .executeUpdate() != 0;
    }

    @Override
    @Transactional
    public Meal get(int id, int userId) {
        List<Meal> meals = em.createNamedQuery(Meal.GET, Meal.class)
                .setParameter("id", id)
                .setParameter("user_id", userId)
                .getResultList();

        return DataAccessUtils.singleResult(meals);
    }

    @Override
    @Transactional
    public List<Meal> getAll(int userId) {

        return em.createNamedQuery(Meal.GETALL, Meal.class)
                .setParameter("user_id", userId)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {

        List<Meal> meals = em.createNamedQuery(Meal.GETBETWEEN, Meal.class)
                .getResultList().stream().filter(meal ->
                        meal.getDateTime().isAfter(startDate) && meal.getDateTime().isBefore(endDate))
                .collect(Collectors.toList());
        return meals;
    }
}