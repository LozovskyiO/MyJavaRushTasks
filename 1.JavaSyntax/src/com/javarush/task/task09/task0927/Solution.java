package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
Есть класс кот - Cat, с полем "имя" (String).
Создать словарь Map<String, Cat> и добавить туда 10 котов в виде "Имя"-"Кот".
Получить из Map множество(Set) всех котов и вывести его на экран.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод createMap должен создавать новый объект HashMap<String, Cat>.
3. Метод createMap должен добавлять в словарь 10 котов в виде «Имя»-«Кот».
4. Метод createMap должен возвращать созданный словарь.
5. Метод convertMapToSet должен создать и вернуть множество котов, полученных из переданного словаря.
6. Программа должна вывести всех котов из множества на экран.*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> mapOfCats= new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Cat cat = new Cat("Vas"+i);
            mapOfCats.put(cat.name,cat );
        }
        return mapOfCats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> cats = new HashSet<>();
        Iterator<Map.Entry<String, Cat>> itr = map.entrySet().iterator();
        while (itr.hasNext()){
            cats.add(itr.next().getValue());
        }
        return cats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {

            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
