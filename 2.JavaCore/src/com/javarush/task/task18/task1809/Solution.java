package com.javarush.task.task18.task1809;

/* 
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();


        FileInputStream fis = new FileInputStream(path1);
        FileOutputStream fos1 = new FileOutputStream(path2);


        int sizeFile = fis.available();

        byte[] byteArrayOfFile = new byte[sizeFile];

        fis.read(byteArrayOfFile);

        for (int i = byteArrayOfFile.length-1; i >=0 ; i--) {
            fos1.write(byteArrayOfFile[i]);
        }


        fis.close();
        fos1.close();
    }
}
