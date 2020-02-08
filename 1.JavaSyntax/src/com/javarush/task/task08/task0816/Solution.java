package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* 
Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.*/

public class Solution {

    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Stallone1", df.parse("JANUARY 1 1980"));
        map.put("Stallone2", df.parse("AUGUST 1 1980"));
        map.put("Stallone3", df.parse("JULY 1 1980"));
        map.put("Stallone4", df.parse("MAY 1 1980"));
        map.put("Stallone5", df.parse("APRIL 1 1980"));
        map.put("Stallone6", df.parse("DECEMBER 1 1980"));
        map.put("Stallone8", df.parse("NOVEMBER 1 1980"));
        map.put("Stallone7", df.parse("SEPTEMBER 1 1980"));
        map.put("Stallone9", df.parse("JUNE 1 1981"));

     return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {

            map.values().removeIf(s -> s.getMonth()==5);
            map.values().removeIf(s -> s.getMonth()==6);
            map.values().removeIf(s -> s.getMonth()==7);


    }

    public static void main(String[] args) throws ParseException {

    }
}
