package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameAndPath = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileNameAndPath);

        int maxOccurence = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (inputStream.available()>0){
            int data = inputStream.read();
            if (!map.containsKey(data)) {

                map.put(data, 1);

            }
                else {
                    map.put(data, map.get(data)+1);
                }

                if (map.get(data)>maxOccurence) maxOccurence = map.get(data);
        }
        inputStream.close();
        reader.close();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()== maxOccurence) {
                System.out.print(entry.getKey() + " ");
            }
        }


    }

}
