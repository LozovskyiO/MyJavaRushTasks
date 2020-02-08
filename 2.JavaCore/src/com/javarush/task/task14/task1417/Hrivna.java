package com.javarush.task.task14.task1417;

public class Hrivna extends Money {
    private double amount;

    public Hrivna(double amount) {
        super(amount);
        this.amount = amount;
    }

    @Override
    public double getAmount() {

        return amount;

    }

    @Override
    public String getCurrencyName() {
        return "UAH";
    }
}
