package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.


Требования:
1. Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
2. Метод getFileTree должен возвращать список строк.
3. Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
4. Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать).
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileList = new ArrayList<>();
        Queue<File> directories = new LinkedList<>();
        File rootPath = new File(root);

        File[] arrayOfFiles = rootPath.listFiles();
        //System.out.println(rootPath.isDirectory());

        for (File f :
                arrayOfFiles) {
            if (f.isDirectory()) {
                directories.add(f);
            } else {
                fileList.add(f.getAbsolutePath());
            }

        }

        while (!directories.isEmpty()){
            File[] filesInDirectories = directories.poll().listFiles();
            for (File f :
                    filesInDirectories) {
                if (f.isDirectory()){
                    directories.add(f);
                } else {
                    fileList.add(f.getAbsolutePath());
                }

            }
        }
        return fileList;

    }

    public static void main(String[] args) {

        List<String> fileList = new ArrayList<>();
        try {
            fileList =  getFileTree("d:/tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
       // fileList.forEach(f-> System.out.println(f));
    }
}
