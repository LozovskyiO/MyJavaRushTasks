package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10


Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла(FileInputStream).*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String fileName = null;
        try {
            fileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(fileName);
        ArrayList<Integer> intArray = new ArrayList<>();

        BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        try {
            String s;
            while ((s = readerFile.readLine()) != null) {
                intArray.add(Integer.parseInt(s));
            }
            reader.close();
            readerFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(intArray);
        for (int i :
                intArray) {
           if ((i%2)==0) System.out.println(i);
        }

    }
}
