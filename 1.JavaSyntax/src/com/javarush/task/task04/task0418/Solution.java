package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
Ввести с клавиатуры два целых числа, и вывести на экран минимальное из них.
Если два числа равны между собой, необходимо вывести любое.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить на экран минимальное из двух целых чисел.
4. Если два числа равны между собой, необходимо вывести любое.*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println(compare(num1, num2));

    }

    private   static int compare (int a, int b){
        if (a < b) { return a; }
        else if (a==b) { return b;}
        else return b;

    }
}