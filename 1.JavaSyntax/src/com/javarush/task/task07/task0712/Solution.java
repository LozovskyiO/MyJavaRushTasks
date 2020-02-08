package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3. Должна быть выведена одна строка.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
3. Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
4. Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
5. Должна быть выведена только одна строка.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();
        int[] length = new int[10];
        int minLength, maxLength, maxIndex=0, minIndex=0;

        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextLine());
            length[i] = list.get(i).length();
        }

        minLength = length[0];
        maxLength = length[0];

        for (int i = 0; i < 10; i++) {
            if (minLength > length[i] && minLength!=length[i]) {
                minLength = length[i];
                minIndex = i;
            }

            if (maxLength < length[i] && maxLength !=length[i]) {
                maxLength = length[i];
                maxIndex = i;
            }
        }

        if (minIndex < maxIndex) {
            System.out.println(list.get(minIndex));
        } else {
            System.out.println(list.get(maxIndex));
        }


    }
}
