package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {

    DrinkMaker drinkMaker = new TeaMaker();
    drinkMaker.makeDrink();

    drinkMaker = new LatteMaker();
    drinkMaker.makeDrink();
    }
}
