package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
Выведенные числа должны быть разделены пробелом.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить числа на экран.
3. Выведенные числа должны быть разделены пробелом.
4. Программа должна выводить числа в порядке убывания.*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
       int b = sc.nextInt();
       int c = sc.nextInt();

       if (a >= b && a >= c && c >= b ) System.out.println(a + " " + c + " " + b);
       else if (a >= b && a <= c && b >= c ) System.out.println(a + " " + b + " " + c);
       else if (b >= a && b >= c && a >= c ) System.out.println(b + " " + a + " " + c);
       else if (b >= a && b >= c && c >= a ) System.out.println(b + " " + c + " " + a);
       else if (c >= b && c >= a && b >= a ) System.out.println(c + " " + b + " " + a);
       else if (c >= b && c >= a && a >= b ) System.out.println(c + " " + a + " " + b);



    }
}
