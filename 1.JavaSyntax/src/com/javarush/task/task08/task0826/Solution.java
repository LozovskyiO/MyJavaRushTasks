package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.Collections;

/* 
Пять победителей
Создать массив на 20 чисел.
Заполнить его числами с клавиатуры.
Вывести пять наибольших чисел.
Каждое значение с новой строки.


Требования:
1. Программа должна выводить числа на экран.
2. Программа должна считывать значения с клавиатуры.
3. Класс Solution должен содержать два метода.
4. Метод sort() должен сортировать массив чисел от большего к меньшему.
5. Метод main() должен вызывать метод sort().
6. Программа должна выводить пять наибольших чисел массива. Каждое значение с новой строки.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);


    }

    /*
    процедура бульбашка( A : список елементів придатних для сортування )
   повторювати
     переставлені = хиба
     для i = 1 включно до довжина(A) - 1 робити:
        якщо ця двійка невпорядкована
    якщо A[i-1] > A[i] тоді
        /* поміняти місцями і запам'ятати, що щось змінилось
    переставити( A[i-1], A[i] )
    переставлені = істина
    кінець якщо
    кінець для
    доки не переставлені
    кінець процедури
     */

    public static void sort(int[] array) {
        int temp, max;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 0; j < array.length-1; j++) {
                if(array[j] < array[j+1]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    flag =true;
                }
            }
        }

    }
}
