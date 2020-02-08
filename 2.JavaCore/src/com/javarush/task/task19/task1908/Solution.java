package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
        String fileFirstPath = bufferedReader1.readLine();
        String fileSecondPath = bufferedReader1.readLine();
        bufferedReader1.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileFirstPath));

        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready())
        {
            char ch =(char) bufferedReader.read();
            stringBuilder.append(ch);
        }
        bufferedReader.close();


        String[] parsedString = stringBuilder.toString().split(" ");
        List<Integer> parsedIntegerList = new ArrayList<>();

       BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileSecondPath));

        for (String s :
                parsedString) {
            try{
                fileWriter.write(String.valueOf(Integer.parseInt(s))+" ");
            } catch (Exception e){
            }
        }

        fileWriter.close();

    }
}
