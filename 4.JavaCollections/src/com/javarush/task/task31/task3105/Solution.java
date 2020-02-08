package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.


Требования:
1. В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все содержимое.
2. В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
3. В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
4. В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
5. Потоки для работы с архивом должны быть закрыты.

Если нужно дополнить архив файлом, то надо сначала считать весь текущий архив куда-то. Записать его то есть, например
в тот же ByteArrayOutputStream , например используя Карту Map где будет ZipEntry, ByteArrayOutputStream  ну или имя
 файла и ByteArrayOutputStream , далее уже считав, надо создать архив и заполнить его.
Создаем архив через ZipOutputStream > FileInputStream "c:/my.zip". И далее из карты уже имея ZipEntry и массив данных,
 можно восстанавливать, создавая новые ZipEntry и заполняя их данными из массива соответственно. Когда скопировали все
 что было из старого арзива, можно теперь дописывать файлы, опять же путем создания
 ZipEntry newFile = new ZipEntry("имя нового файла в архиве");
Вставить его в архив zipOutputStream.putNextEntry(newFile );
И можно заполнить этот новый файл чем-то или скопировать в него содержимое уже из другого файла(sourceFile).
Files.copy(sourceFile, zipOutputStream);
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);

        Map<String, ByteArrayOutputStream> mapOfZipEntries = new HashMap<>();

        ZipEntry zippedFilesEntry;

        String newFileName = Paths.get(args[0]).getFileName().toString();
        String newPathInArchive = "new/" + newFileName;

        while ((zippedFilesEntry=zipInputStream.getNextEntry())!=null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int length = 0;
            byte[] buffer = new byte[1024];
            while ((length = zipInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, length);
            }
            mapOfZipEntries.put(zippedFilesEntry.getName(), byteArrayOutputStream);
        }

        zipOutputStream.putNextEntry(new ZipEntry(newPathInArchive));
        Files.copy(Paths.get(args[0]), zipOutputStream);

        for (Map.Entry<String, ByteArrayOutputStream> pair : mapOfZipEntries.entrySet()) {
            zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
            pair.getValue().writeTo(zipOutputStream);
        }

        zipInputStream.close();
        zipOutputStream.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
