package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
В метод main приходят три параметра:
1) fileName - путь к файлу;
2) number - число, позиция в файле;
3) text - текст.

Считать текст с файла начиная с позиции number, длинной такой же как и длинна переданного текста в третьем параметре.
Если считанный текст такой же как и text, то записать в конец файла строку 'true', иначе записать 'false'.
Используй RandomAccessFile и его методы seek(long pos), read(byte[] b, int off, int len), write(byte[] b).
Используй один из конструкторов класса String для конвертации считанной строчки в текст.


Требования:
1. В методе main класса Solution необходимо использовать RandomAccessFile, который должен использовать файл, который приходит первым параметром.
2. В методе main класса Solution программа должна устанавливать позицию в файле, которая передана во втором параметре.
3. В методе main класса Solution программа должна считывать данные с файла при помощи метода read(byte[] b, int off, int len).
4. Запись должна происходить в конец файла.
5. Если считанный текст такой же как и text, то программа должна записать в конец переданного файла строку 'true'.
6. Если считанный текст НЕ такой же как и text, то программа должна записать в конец переданного файла строку 'false'.*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        long filesize = raf.length();
        int textLength = args[2].length();
        byte[] byteArray = new byte[textLength];
//        System.out.println(byteArray.length);
//        System.out.println(textLength);
        raf.seek(Long.parseLong(args[1]));
       raf.read(byteArray, 0, args[2].length());
        //raf.read(byteArray, 0, 13);
        //raf.read(byteArray);
        String readText = new String(byteArray, StandardCharsets.UTF_8);
        System.out.println(readText);
        byte[] byteTrue = "true".getBytes();
        byte[] byteFalse = "false".getBytes();
        if (readText.equals(args[2])){
            raf.seek(raf.length());
            raf.write(byteTrue);
        } else {
            raf.seek(raf.length());
            raf.write(byteFalse);
        }
    }
}
