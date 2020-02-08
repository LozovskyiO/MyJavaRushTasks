package com.javarush.task.task08.task0818;

import java.util.*;

import static java.lang.Math.random;

/* 
Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: "фамилия" - "зарплата".
Удалить из словаря всех людей, у которых зарплата ниже 500.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
4. Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String,Integer> map = new HashMap<>(); // declaring new map

        for (int i = 0; i < 10; i++) {
            int value =Math.toIntExact(i*90*Math.round(random())) ;  // generating random value for map entry
            map.put("Fam"+i, value);
        }
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {

        Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator(); //creating iterator for map

        ArrayList<String> listOfKeys = new ArrayList<>(); //creating list of the keys where values lower than 500

        while(itr.hasNext())  //Let's iterate whole map collection
        {
            Map.Entry<String, Integer> entry = itr.next();  //assigning map element to entry

            if (entry.getValue()<500) {
                listOfKeys.add(entry.getKey()); //if value lower than 500 - add it's key to list of the keys
            }
        }

        //Here we deleting all values which are lower than 500
        for (String key :
                listOfKeys) {
            map.remove(key);

        }


    }

    public static void main(String[] args) {


    }
}