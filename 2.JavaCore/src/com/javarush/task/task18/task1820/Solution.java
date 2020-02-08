package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String path1 = null;
        String path2 = null;

        try {
            path1 = bufferedReader.readLine();
            path2 = bufferedReader.readLine();
        } catch (Exception e){
            System.out.println(e);
        }

        String fileContent = null;

        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path1));
            byte[] byteArray1 = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(byteArray1);

            fileContent = new String(byteArray1);
            bufferedReader.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(fileContent);
        String[] parsedStringArray = fileContent.split(" ");


        for (int i = 0; i < parsedStringArray.length; i++) {
            int roundedNumber = Math.round(Float.parseFloat(parsedStringArray[i]));
            parsedStringArray[i] = String.valueOf(roundedNumber);
        }

        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path2,false));
            for (String s :
                    parsedStringArray) {
                byte[] bytes = s.getBytes();
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.write(32);
            }
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (String s :
//                parsedStringArray) {
//            System.out.println(s);
//        }


    }
}
