package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
6. Сначала должно идти содержимое второго файла, затем содержимое первого.
7. Созданные для файлов потоки должны быть закрыты.*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String path1 = null;
        String path2 = null;

        try{
            path1 = reader.readLine();
            path2 = reader.readLine();
        } catch (Exception e){
            System.out.println(e);
        }


        try {

            BufferedInputStream bufferedInputStream1 = new BufferedInputStream(new FileInputStream(path1));
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(path2));

            //byte[] byteArray1= bufferedInputStream1.readAllBytes();
            byte[] byteArray1 = new byte[bufferedInputStream1.available()];
            bufferedInputStream1.read(byteArray1);

            byte[] byteArray2 =new byte[bufferedInputStream2.available()];
            bufferedInputStream2.read(byteArray2);

            byte[] byteFinall = new byte[(byteArray1.length + byteArray2.length)];

            for (int i = 0; i <byteArray2.length ; i++) {
                byteFinall[i] = byteArray2[i];
            }

            for (int i = 0; i <byteArray1.length ; i++) {
                byteFinall[byteArray2.length+i] = byteArray1[i];
            }

//            for (int i = 0; i < byteFinall.length; i++) {
//                System.out.println(byteFinall[i]);
//            }
            FileOutputStream fileOutputStream = new FileOutputStream(path1, false);
            fileOutputStream.write(byteFinall);
            fileOutputStream.close();
            bufferedInputStream1.close();
            bufferedInputStream2.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
