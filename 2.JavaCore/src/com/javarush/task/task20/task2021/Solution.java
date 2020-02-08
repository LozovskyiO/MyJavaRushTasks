package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.


Требования:
1. Класс Solution должен поддерживать интерфейс Serializable.
2. Класс SubSolution должен быть создан внутри класса Solution.
3. Класс SubSolution должен быть потомком класса Solution.
4. При попытке сериализовать объект типа SubSolution должно возникать исключение NotSerializableException.
5. При попытке десериализовать объект типа SubSolution должно возникать исключение NotSerializableException.*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {

        public void readObject(ObjectInputStream objectInputStream) throws NotSerializableException {
            throw new NotSerializableException("Не сегодня!");
        }

        public void writeObject(ObjectOutputStream objectOutputStream) throws NotSerializableException {
            throw new NotSerializableException("Не сегодня!");
        }

    }

    public static void main(String[] args) throws IOException {

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        SubSolution subSolution = new SubSolution();

        try {
            oos.writeObject(subSolution);
        } catch (NotSerializableException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        try {
            SubSolution loadedSubSolution = (SubSolution) ois.readObject();
        } catch (NotSerializableException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
