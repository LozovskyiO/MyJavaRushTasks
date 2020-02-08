package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createSet() должен создавать и возвращать множество HashSet состоящих из 20 различных чисел.
5. Метод removeAllNumbersGreaterThan10() должен удалять из множества все числа больше 10.*/

public class Solution {
    public static HashSet<Integer> createSet() {
        // напишите тут ваш код

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 20; i++) {
            set.add(i);
        }

        return set;
    }

    public static HashSet<Integer> removeAllNumbersGreaterThan10(HashSet<Integer> set) {
        HashSet<Integer> newSet = new HashSet<>();
        Iterator value = set.iterator();

        while (value.hasNext()) {
            int numberFromSet = (int) value.next();

            if(numberFromSet<=10){
             newSet.add(numberFromSet);
            }
        }

        return newSet;
    }

    public static void main(String[] args) {

    }
}
