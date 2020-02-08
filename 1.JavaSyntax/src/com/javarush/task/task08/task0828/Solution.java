package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: "May is the 5 month".
Используйте коллекции.


Требования:
1. Программа должна считывать одно значение с клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна использовать коллекции.
4. Программа должна считывать с клавиатуры имя месяца и выводить его номер на экран по заданному шаблону.*/

public class Solution {
    public static void main(String[] args) throws IOException {

        HashMap<String,Integer> monthCollection = new HashMap<>();

        monthCollection.put("January", 1);
        monthCollection.put("February", 2);
        monthCollection.put("March", 3);
        monthCollection.put("April", 4);
        monthCollection.put("May", 5);
        monthCollection.put("June", 6);
        monthCollection.put("July", 7);
        monthCollection.put("August", 8);
        monthCollection.put("September", 9);
        monthCollection.put("October", 10);
        monthCollection.put("November", 11);
        monthCollection.put("December", 12);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String userInput = reader.readLine();

        System.out.println(userInput + " is the " + monthCollection.get(userInput) + " month");

    }
}
