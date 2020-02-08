package com.javarush.task.task04.task0425;

/* 
для первой четверти a>0 и b>0;
для второй четверти a<0 и b>0;
для третьей четверти a<0 и b<0;
для четвертой четверти a>0 и b<0.

Пример для чисел 4 6:
1

Пример для чисел -6 -6:
3

Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна использовать команду System.out.println() или System.out.print().
3. Если точка находится в первой координатной четверти, вывести "1".
4. Если точка находится в второй координатной четверти, вывести "2".
5. Если точка находится в третей координатной четверти, вывести "3".
6. Если точка находится в четвёртой координатной четверти, вывести "4".
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int coordinateX = scanner.nextInt();
        int coordinateY = scanner.nextInt();

        if (coordinateX > 0 && coordinateY> 0) {
                System.out.printf("1");
            }
            else if (coordinateX > 0 && coordinateY < 0) {
                System.out.println("4");
            }
            else if (coordinateX < 0 && coordinateY> 0) {
                System.out.println("2");
            } else System.out.println("3");


    }
}
