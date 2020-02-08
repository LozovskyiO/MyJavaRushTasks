package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while. Каждое значение с новой строки.

Пример ввода:
абв
2

Пример вывода:
абв
абв


Требования:
1. Программа должна считывать текст c клавиатуры.
2. Программа должна выводить текст на экран.
3. Каждое значение должно быть выведено с новой строки.
4. Программа должна выводить на экран строку N раз.
5. В программе должен использоваться цикл while.*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        int numberOfRepeats = sc.nextInt();
        int i =0;
        while (i<numberOfRepeats) {
            System.out.println(text);
            i++;
        }
    }
}
