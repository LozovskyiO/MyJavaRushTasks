package com.javarush.task.task31.task3101;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/*
Проход пПроход по дереву файлов
1. На вход метода main() подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и, если понадобится, FileUtils.isExist()).
3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1. После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
Для создания файлов используй конструктор File(String pathname).


Требования:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt в отсортированном по имени файла порядке.
4. Поток для записи в файл нужно закрыть.
5. Не используй статические переменные.о дереву файлов
*/
public class Solution {
    private static List<File> files = new ArrayList<>();
    public static void main(String[] args) {

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);


        listOfFiles(path);
        System.out.println();
        files.sort(Comparator.comparing(file -> file.getName()));
        files.forEach(f-> fileWriter(f, allFilesContent));
    }

     static public void fileWriter (File file, File destinationFile){
        try
        {
            FileInputStream inputStream = new FileInputStream(file);
            FileOutputStream outputStream = new FileOutputStream(destinationFile, true);
            while(inputStream.available()>0){
               outputStream.write(inputStream.read());
           }
            outputStream.write('\n');
            inputStream.close();
            outputStream.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void  listOfFiles(File path){
        File[] arrayOfFiles = path.listFiles();
        for(File f:arrayOfFiles){
            try {
                if(!f.isDirectory()){
                  // System.out.println(f.getCanonicalPath());
                    if(f.length()<=50) {
                        files.add(f);
                    }
                } else {
                    listOfFiles(f);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
