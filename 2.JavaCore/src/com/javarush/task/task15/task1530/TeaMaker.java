package com.javarush.task.task15.task1530;

public class TeaMaker extends DrinkMaker {

//9. Метод getRightCup в классе TeaMaker должен выводить на экран фразу "Берем чашку для чая".
//10. Метод putIngredient в классе TeaMaker должен выводить на экран фразу "Насыпаем чай".
//11. Метод pour в классе TeaMaker должен выводить на экран фразу "Заливаем кипятком".

    @Override
    public void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    public void pour() {
        System.out.println("Заливаем кипятком");
    }

    @Override
    public void putIngredient() {
        System.out.println("Насыпаем чай");
    }
}
