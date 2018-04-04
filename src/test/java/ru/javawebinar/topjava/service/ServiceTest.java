package ru.javawebinar.topjava.service;

public abstract class ServiceTest {

    //public abstract void setUp() throws Exception;

    public abstract void create() throws Exception;

    public abstract void duplicateCreate() throws Exception;

    public abstract void delete() throws Exception;

    public abstract void notFoundDelete() throws Exception;

    public abstract void get() throws Exception;

    public abstract void getNotFound() throws Exception;

    public abstract void update() throws Exception;

    public abstract void updateNotFound() throws Exception;

    public abstract void getAll() throws Exception;

}
