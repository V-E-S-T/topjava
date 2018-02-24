package ru.javawebinar.topjava.util;

public class Booleanizer
{
    private boolean trueFalse;

    public Booleanizer(boolean trueFalse) {
        this.trueFalse = trueFalse;
    }

    public void setTrueFalse(boolean trueFalse) {
        this.trueFalse = trueFalse;
    }

    public boolean isTrueFalse() {
        return trueFalse;
    }
}
