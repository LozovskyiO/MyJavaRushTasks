package com.javarush.task.task10.task1015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Массив списков строк
Создать массив, элементами которого будут списки строк.
Заполнить массив любыми данными и вывести их на экран.


Требования:
1. Метод createList должен объявлять и инициализировать массив с типом элементов ArrayList<String>.
2. Метод createList должен возвращать созданный массив.
3. Метод createList должен добавлять в массив элементы (списки строк). Списки должны быть не пустые.
4. Программа должна выводить данные на экран.
5. Метод main должен вызывать метод createList.
6. Метод main должен вызывать метод printList.*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] listOfStingArrays = new ArrayList[3];

        String alphabet = "abcdefghijklmnopqrstuvxyz";

        //let's fill array with randomly generated strings
        for (int i = 0; i < listOfStingArrays.length; i++) {

            ArrayList<String> tempList = new ArrayList<>();
            //randomizing amount of elements in arraylist
            int elementAmount = (int) (Math.random()*10+1);
            for (int k = 0; k < elementAmount; k++) {


                int stringLength = (int) (Math.random() * 28);
                String temp = "";

                for (int j = 0; j < stringLength; j++) {
                    temp = temp + alphabet.charAt((int) (Math.random() * 25));
                }
                tempList.add(temp);
            }

            listOfStingArrays[i] = tempList;
        }



        return listOfStingArrays;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}