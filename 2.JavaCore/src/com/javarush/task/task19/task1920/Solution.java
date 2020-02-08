package com.javarush.task.task19.task1920;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();

        while (bufferedReader.ready()){
            String[] strings = bufferedReader.readLine().split(" ");
            map.put(strings[0], (map.containsKey(strings[0]) ? map.get(strings[0]) + Double.parseDouble(strings[1]) : Double.parseDouble(strings[1])));
        }

        double maximum = map.values()
                .stream()
                .max(Double::compareTo)
                .get();
        //System.out.println(maximum);
        bufferedReader.close();
        for (Map.Entry<String, Double> entry : map.entrySet()) {

           if(entry.getValue().equals(maximum)){
               System.out.println(entry.getKey());
           }
        }



    }
}
