package com.javarush.task.task19.task1910;

/* 
Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.

Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где удалены все знаки пунктуации, включая символы новой строки (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;



public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = bufferedReader1.readLine();
        String fileTwo = bufferedReader1.readLine();
        bufferedReader1.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileOne));

        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready())
        {
            char ch =(char) bufferedReader.read();
            stringBuilder.append(ch);
        }
        bufferedReader.close();

        String collectedString = stringBuilder.toString();
        stringBuilder.setLength(0);
        String result = collectedString.replaceAll("[^a-zA-Z\\d\\s[\\n]]", "");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTwo));
        bufferedWriter.write(result);
        bufferedWriter.close();

    }
}
