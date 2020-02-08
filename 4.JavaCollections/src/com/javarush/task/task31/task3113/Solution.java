package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/* 

Всего папок - [количество папок в директории и поддиректориях]
Всего файлов - [количество файлов в директории и поддиректориях]
Общий размер - [общее количество байт, которое хранится в директории]


*/
public class Solution {
    private static long folderSize = 0;
    private static int foldersAmount = -1;
    private static long filesAmount;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Path enteredPath = Paths.get(bufferedReader.readLine());
        bufferedReader.close();
        if(Files.isDirectory(enteredPath)){
            Files.walkFileTree(enteredPath, new MyFileVisitor());
            Stream<Path> subPaths = Files.walk(enteredPath);
            subPaths.forEach(f -> {
                if(!Files.isDirectory(f)){
                    try {
                        folderSize=folderSize+ Files.size(f);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("Всего папок - " + foldersAmount);
            System.out.println("Всего файлов - " + filesAmount);
            System.out.println("Общий размер - " + folderSize);
        } else {

            System.out.println(enteredPath.toAbsolutePath().toString() + " - не папка");
        }
    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {
        public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs) throws IOException {
            foldersAmount ++;
            return FileVisitResult.CONTINUE;
        }

        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
           filesAmount ++;
            return FileVisitResult.CONTINUE;
        }
    }


}




