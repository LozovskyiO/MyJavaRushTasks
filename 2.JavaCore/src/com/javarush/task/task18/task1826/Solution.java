package com.javarush.task.task18.task1826;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

       FileInputStream inputStream = new FileInputStream(args[1]);
       FileOutputStream outputStream = new FileOutputStream(args[2]);
       boolean flag = false;
       switch (args[0]) {
           case "-e":
                    while (inputStream.available() > 0) {
                        int readByte = inputStream.read();
                        if (!flag) {
                            flag = true;
                            outputStream.write(42);
                        }
                        outputStream.write(readByte);
                        flag = false;
                    }
                    break;
           case "-d":
               List<Byte> byteArray = new ArrayList<>();
               while (inputStream.available() > 0) {
                   byteArray.add((byte) inputStream.read());
               }

               for (int i = 1; i < byteArray.size(); i=i+2) {
                    outputStream.write(byteArray.get(i));
               }
                    break;
       }
       inputStream.close();
       outputStream.close();
    }
}
