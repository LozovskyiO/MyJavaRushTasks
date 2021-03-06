package com.javarush.task.task15.task1530;

public abstract class DrinkMaker {

    public abstract void getRightCup();

    public abstract void pour();

    public abstract void putIngredient();

    public void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }

}
