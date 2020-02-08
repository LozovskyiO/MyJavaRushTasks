package com.javarush.task.task08.task0815;

import java.util.*;

import static java.lang.Math.random;

/* 
Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, String состоящих из 10 записей по принципу «Фамилия» - «Имя».
4. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
5. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>(); // initializing new HashMap

        map.put("Lozo", "Alex");
        map.put("Bash", "Alex");
        map.put("Baraa", "Alex");
        map.put("Shchepan", "Alex");
        map.put("Sakhar", "Alex");
        map.put("Kost", "Alex2");
        map.put("Burma", "Alex1");
        map.put("Meln", "Alex");
        map.put("Matu", "Alex");
        map.put("Lih", "Alex");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {

        int count = 0;

        for (String s:
                map.values()) {
            if (s.equals(name)) {  count+=1;}
        }

        return count;



    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;

        for (String s:
                map.keySet()) {
            if (s.equals(lastName)) {  count+=1;}
        }

        return count;

    }

    public static void main(String[] args) {

        HashMap <String, String> hm = createMap ();
//        System.out.println(getCountTheSameFirstName (hm, "Петр" ));
//        System.out.println(getCountTheSameLastName (hm, "Толстой" ));
    }
}
