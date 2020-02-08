package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (num<1 || num > 999) {}
        else if (num<10 && num%2==0) { System.out.println("четное однозначное число");}
        else if (num<10 && num%2!=0) { System.out.println("нечетное однозначное число");}
        else if (num<100 && num%2==0) {System.out.println("четное двузначное число");}
        else if (num<100 && num%2!=0) {System.out.println("нечетное двузначное число");}
        else if (num<1000 && num%2==0) {System.out.println("четное трехзначное число");}
        else if (num<1000 && num%2!=0) {System.out.println("нечетное трехзначное число");}
        else {
            System.out.println("");
        }


    }
}
