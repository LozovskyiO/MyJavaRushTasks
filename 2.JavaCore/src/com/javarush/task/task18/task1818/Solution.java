package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.*/

import java.io.*;
import java.sql.SQLOutput;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String path1 = null;
        String path2 = null;
        String path3 = null;

        try{
            path1 = reader.readLine();
            path2 = reader.readLine();
            path3 = reader.readLine();
        } catch (Exception e){
            System.out.println(e);
        }
        int i ;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path1);
            BufferedInputStream bufferedInputStream1 = new BufferedInputStream(new FileInputStream(path2));
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(path3));


            while ((i=bufferedInputStream1.read())!=-1){
                fileOutputStream.write(i);
            }

            fileOutputStream.close();
            FileOutputStream fileOutputStream1 = new FileOutputStream(path1, true);
            while ((i=bufferedInputStream2.read())!=-1){
                fileOutputStream1.write(i);
            }

            fileOutputStream1.close();
            bufferedInputStream1.close();
            bufferedInputStream2.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}













