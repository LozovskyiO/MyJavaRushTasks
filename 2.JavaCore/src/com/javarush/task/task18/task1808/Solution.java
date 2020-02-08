package com.javarush.task.task18.task1808;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = reader.readLine();
        String path2 = reader.readLine();
        String path3 = reader.readLine();

        FileInputStream fis = new FileInputStream(path1);
        FileOutputStream fos1 = new FileOutputStream(path2);
        FileOutputStream fos2 = new FileOutputStream(path3);

        int sizeFile = fis.available();
        int sizeFile2 =0;
        int sizeFile3 =0;

        byte[] byteArrayOfFile1 = new byte[sizeFile];

        if (sizeFile%2 !=0 )
        {
            sizeFile2 = (sizeFile-1)/2 +1;
            sizeFile3 = (sizeFile -1)/2;
        } else
        {
            sizeFile2 = sizeFile/2;
            sizeFile3 = sizeFile/2;
        }

        byte[] buffer = new byte[sizeFile2];
        //while (fis.available() > 0)
        {
            fis.read(buffer);
            fos1.write(buffer);
        }

        byte[] buffer1 = new byte[sizeFile3];
        //while (fis.available() > 0)
        {
            fis.read(buffer1);
            fos2.write(buffer1);
        }
        fis.close();
        fos1.close();
        fos2.close();
    }


}
