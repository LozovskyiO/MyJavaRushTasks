package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Отслеживаем изменения
Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.


Требования:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List<LineItem>, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций ADDED, REMOVED, SAME.*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName1));
        List<String> listOfLinesFromFile1 = new LinkedList<>();
        while (bufferedReader1.ready()) {
            listOfLinesFromFile1.add(bufferedReader1.readLine());
        }
        bufferedReader1.close();

        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileName2));
        List<String> listOfLinesFromFile2 = new LinkedList<>();
        while (bufferedReader2.ready()) {
            listOfLinesFromFile2.add(bufferedReader2.readLine());
        }
        bufferedReader2.close();


        while (!listOfLinesFromFile1.isEmpty()){
            if (listOfLinesFromFile2.isEmpty()){
                lines.add(new LineItem(Type.REMOVED, listOfLinesFromFile1.get(0)));
                break;
            }
            if (listOfLinesFromFile1.get(0).equals(listOfLinesFromFile2.get(0))){
                lines.add(new LineItem(Type.SAME, listOfLinesFromFile1.get(0)));
                if (!listOfLinesFromFile1.isEmpty()) listOfLinesFromFile1.remove(0);
                if(!listOfLinesFromFile2.isEmpty())  listOfLinesFromFile2.remove(0);
            } else if (listOfLinesFromFile1.get(0).equals(listOfLinesFromFile2.get(1))) {
                lines.add(new LineItem(Type.ADDED, listOfLinesFromFile2.remove(0)));
            } else if (!listOfLinesFromFile1.get(0).equals(listOfLinesFromFile2.get(1))) {
                lines.add(new LineItem(Type.REMOVED, listOfLinesFromFile1.remove(0)));
            }
            if (listOfLinesFromFile1.isEmpty() && !listOfLinesFromFile2.isEmpty()){
                lines.add(new LineItem(Type.ADDED, listOfLinesFromFile2.remove(0)));
                break;
            }
        }
//
//        А1 == Б1 - значит SAME
//        А1 != Б1, но А1 == Б2 - значит Б1 ADDED
//        А1 != Б1 и А1 != Б2 - значит А1 REMOVED
//
//        Перебрали весь столбец, но остались неиспользованные значения в столбце Б (как в примере №2 в условиях)? Добавляем их как ADDED.
        //  listOfLinesFromFile1.forEach(s -> System.out.println(s));
       // listOfLinesFromFile2.forEach(s -> System.out.println(s));
            lines.forEach(s-> System.out.println(s.type.toString() + " " + s.line));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
