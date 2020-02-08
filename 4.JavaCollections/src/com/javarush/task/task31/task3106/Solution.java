package com.javarush.task.task31.task3106;

/* 
Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002


Требования:
1. В методе main нужно создать ZipInputStream для архива, собранного из кусочков файлов. Файлы приходят аргументами в main, начиная со второго.
2. Создай поток для записи в файл, который приходит первым аргументом в main. Запиши туда содержимое файла из архива.
3. Поток для чтения из архива должен быть закрыт.
4. Поток для записи в файл должен быть закрыт.*/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Solution {

    public static void main(String[] args) throws IOException {

        String finalFileName = args[0];
        Set<String> set = Arrays.stream(args).skip(1).collect(Collectors.toCollection(TreeSet::new));
        byte[] buffer =new byte[1024];
        Vector<InputStream> vector = new Vector<>();
        FileOutputStream fos = new FileOutputStream(finalFileName);

        set.forEach(x-> {
            try {
                vector.add(new FileInputStream(x));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        try(ZipInputStream zipInputStream = new ZipInputStream(
                new SequenceInputStream(vector.elements()))){
            ZipEntry entry = zipInputStream.getNextEntry();

            int countOfBytes;
            while ((countOfBytes = zipInputStream.read(buffer))>0) {
                fos.write(buffer, 0, countOfBytes);
                fos.flush();
            }
            zipInputStream.closeEntry();
        }
        fos.close();

    }
}