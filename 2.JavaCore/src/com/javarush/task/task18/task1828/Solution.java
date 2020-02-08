package com.javarush.task.task18.task1828;

/* 
Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:

-d id

Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.
*/

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
                    case "-d":
                        deleteProduct(args, fileName, listOfFileLines);
                        break;
                    case "-u":
                        updateProduct(args, fileName, listOfFileLines );
                        break;
                }
            }

        }

    private static void deleteProduct(String[] args, String fileName, List<String> listFileLines) throws IOException{
            int id=0;
            for (int i = 0; i < listFileLines.size(); i++) {
                String stringIdToken = listFileLines.get(i).substring(0,8).trim();
                if (stringIdToken.equals(args[1])){
                    id = i;
                    break;
                }
            }

            listFileLines.remove(id);

            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
            for (String line :
                listFileLines) {
                line+="\r\n";
                byte[] lineInBytes = line.getBytes();
                fileOutputStream.write(lineInBytes);
            }
            fileOutputStream.close();
    }

    private static void updateProduct(String[] args, String fileName, List<String> listFileLines ) throws IOException {
            int idValue = 0;
            for (int i = 0; i < listFileLines.size(); i++) {
                String stringIdToken = listFileLines.get(i).substring(0,8).trim();
                if (stringIdToken.equals(args[1])){
                    idValue = i;
                    break;
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("%-8s",args[1]));
            stringBuilder.append(String.format("%-30s",args[2]));
            stringBuilder.append(String.format("%-8s",args[3]));
            stringBuilder.append(String.format("%-4s",args[4]));
            listFileLines.set(idValue,stringBuilder.toString());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
            for (String line :
                listFileLines) {
                line+="\r\n";
                byte[] lineInBytes = line.getBytes();
                fileOutputStream.write(lineInBytes);
            }
            fileOutputStream.close();

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
