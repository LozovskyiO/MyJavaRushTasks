package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(args[0]);
        Map<Integer, Integer> mapOfSymbolOccurence = new HashMap<>();
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(args[0]));
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                if (mapOfSymbolOccurence.containsKey(i)) {

                    mapOfSymbolOccurence.put(i, mapOfSymbolOccurence.get(i) + 1);

                } else mapOfSymbolOccurence.put(i, 1);

            }
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //mapOfSymbolOccurence.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));
        byte[] byteArray = new byte[mapOfSymbolOccurence.size()];

        int i=0;
        for (Integer key : mapOfSymbolOccurence.keySet()) {
            byteArray[i] = (byte) key.intValue();
            i++;
        }

        Arrays.sort(byteArray);

        for (int j = 0; j < byteArray.length; j++) {
            int temp = mapOfSymbolOccurence.get((int) byteArray[j]);
            char charTemp = (char)(byteArray[j]);
            System.out.println(charTemp + " " + temp);
        }
    }
}


