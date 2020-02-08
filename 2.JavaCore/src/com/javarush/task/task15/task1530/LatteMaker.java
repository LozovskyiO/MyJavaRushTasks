package com.javarush.task.task15.task1530;

public class LatteMaker extends DrinkMaker {
//            6. Метод getRightCup в классе LatteMaker должен выводить на экран фразу "Берем чашку для латте".
//            7. Метод putIngredient в классе LatteMaker должен выводить на экран фразу "Делаем кофе".
//            8. Метод pour в классе LatteMaker должен выводить на экран фразу "Заливаем молоком с пенкой".

    @Override
    public void getRightCup() {
        System.out.println("Берем чашку для латте");
    }

    @Override
    public void pour() {
        System.out.println("Заливаем молоком с пенкой");
    }

    @Override
    public void putIngredient() {
        System.out.println("Делаем кофе");
    }
}
