package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, String состоящих из 10 записей.
4. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
5. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>(); // initializing new HashMap

        map.put("Lozo", "Alex");
        map.put("Bash", "Alex3");
        map.put("Baraa", "Alex3");
        map.put("Shchepan", "Alex");
        map.put("Sakhar", "Alex");
        map.put("Kost", "Alex2");
        map.put("Burma", "Alex1");
        map.put("Meln", "Alex");
        map.put("Matu", "Alex2");
        map.put("Lih", "Alex");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {

       ArrayList<String> listOfDoublicateNames = new ArrayList<>();


        for (String s  :
             map.values()) {

            int count = 0;
            for (String innerS :
                    map.values()) {

                if (s.equals(innerS)) {
                    count++;
                }

                if (count > 1) {
                    listOfDoublicateNames.add(s);
                }
            }
        }

        for (int i = 0; i < listOfDoublicateNames.size(); i++) {
            removeItemFromMapByValue(map, listOfDoublicateNames.get(i));

        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();

        removeTheFirstNameDuplicates(map);


    }
}
