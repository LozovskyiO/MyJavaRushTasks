package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
мама мыла раму.

Пример вывода:
Мама Мыла Раму.


Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать строку с клавиатуры.
3. Класс Solution должен содержать один метод.
4. Программа должна заменять в тексте первые буквы всех слов на заглавные.*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();



        //String[] stringArray = s.split("\\s");

        char[] charArray = s.toCharArray();

        char[] newCharArray = new char[charArray.length];



        for (int i = 0; i <charArray.length ; i++) {
            if (i==0) {
                if (charArray[i] !=' '){
                    newCharArray[i] = Character.toUpperCase(charArray[i]);
                } else newCharArray[i] = charArray[i];
            } else {
                if (charArray[i-1] == ' '&&charArray[i]!=' ') {
                    newCharArray[i] = Character.toUpperCase(charArray[i]);
                } else {
                    newCharArray[i] = charArray[i];
                }
            }


        }

        String newString = new String(newCharArray);
        System.out.println(newString);
    }
}
