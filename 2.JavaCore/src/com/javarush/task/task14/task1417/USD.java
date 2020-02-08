package com.javarush.task.task14.task1417;

public class USD extends Money {
    private double amount;

    public USD(double amount) {
        super(amount);
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return this.amount;

    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }
}
