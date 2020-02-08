package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* 
Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo&param1=12&param2=123

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double: 3.14


Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Класс Solution не должен содержать статические поля.
3. Программа должна выводить данные на экран в соответствии с условием.
4. Программа должна вызывать метод alert с параметром double в случае, если значение параметра obj может быть корректно преобразовано в число типа double.
5. Программа должна вызывать метод alert с параметром String в случае, если значение параметра obj НЕ может быть корректно преобразовано в число типа double.
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = null;

        try {
            url = reader.readLine();
            reader.close();
        } catch (Exception e) {
        }

        int paramStart = 0;

        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '?') {
                paramStart = i;
                break;
            }
        }

        LinkedHashMap<String, String> param = new LinkedHashMap<>();


        url = url.substring(paramStart + 1, url.length());
        for (String retval : url.split("&")) {


            String key, value;
            if (retval.contains("=")){
                int i = retval.indexOf("=");
                key = retval.substring(0, i);
                value = retval.substring(i+1, retval.length());
                param.put(key, value);
            } else {
                key = retval;
                value = null;
                param.put(key, value);
            }
        }

        boolean flag=false;
        for (String key :
                param.keySet()) {
            System.out.print(key + " ");
            if (key.equals("obj")) flag = true;
        }

        System.out.println();
        if (flag){
            try {
                double d = Double.parseDouble(param.get("obj"));
                alert(d);
            } catch (NumberFormatException e) {
               alert(param.get("obj"));
            }
        }


    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
