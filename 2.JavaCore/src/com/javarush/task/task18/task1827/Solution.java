package com.javarush.task.task18.task1827;

/* 
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. В классе Solution не должны быть использованы статические переменные.
3. При запуске программы без параметров список товаров должен остаться неизменным.
4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
5. Товар должен иметь следующий id, после максимального, найденного в файле.
6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
7. Созданные для файлов потоки должны быть закрыты.*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> listOfFileLines = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String line = fileReader.readLine();
        int maxId = 0;
        while (line != null) {
            listOfFileLines.add(line);
            String stringIdToken = line.substring(0,8).trim();
            int tempId =Integer.parseInt(stringIdToken);
            if(tempId>maxId) {
                maxId = tempId;
            }
            line = fileReader.readLine();
        }
        fileReader.close();

        if (args.length>0) {
            switch (args[0]) {
                case "-c":
                    addingNewProduct(args, fileName, maxId);
                    break;
            }
        }

    }

    private static void addingNewProduct(String[] args, String fileName, int maxId) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName), true);
        StringBuilder stringBuilder = new StringBuilder();
        String id =String.format("%-8s",String.valueOf(maxId+1) );
        String productName = String.format("%-30s",args[1] );
        String price = String.format("%-8s",args[2] );
        String quantity = String.format("%-4s",args[3] );


        stringBuilder.append(id);
        stringBuilder.append(productName);
        stringBuilder.append(price);
        stringBuilder.append(quantity);
        byte[] lineInBytes = stringBuilder.toString().getBytes();
        fileOutputStream.write(10);
        fileOutputStream.write(lineInBytes);
        fileOutputStream.close();
    }
}
