package com.javarush.task.task04.task0428;

/* 
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел среди этих трех.

Примеры:
а) при вводе чисел
-4
6
6
получим вывод
2

б) при вводе чисел
-6
-6
-3
получим вывод
0
в) при вводе чисел
0
1
2
получим вывод
2

Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить количество положительных чисел в исходном наборе.
4. Если положительных чисел нет, программа должна вывести "0".
5. Учти, что "0" не относится ни к положительным, ни к отрицательным числам.*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int count = 0;

        if (num1> 0) {count++;}
        if (num2> 0) {count++;}
        if (num3> 0) {count++;}

        System.out.println(count);

    }
}