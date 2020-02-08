package com.javarush.task.task04.task0441;


/* 
Как-то средненько
Ввести с клавиатуры три числа, вывести на экран среднее из них.
Т.е. не самое большое и не самое маленькое.
Если все числа равны, вывести любое из них.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить среднее из трех чисел.
4. Если все числа равны, вывести любое из них.
5. Если два числа из трех равны, вывести любое из двух.*/
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int[] ar = new int[3];
         ar[0] = sc.nextInt();
         ar[1] = sc.nextInt();
         ar[2] = sc.nextInt();
        Arrays.sort(ar);

        System.out.println(ar[1]);

    }
}
