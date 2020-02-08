package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3

Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.


Требования:
1. Программа должна выводить число на экран.
2. Программа должна считывать значения с клавиатуры.
3. В методе main объяви переменную типа ArrayList с типом элементов Integer и сразу проинициализируй ee.
4. Программа должна добавлять в коллекцию 10 чисел, согласно условию.
5. Программа должна выводить на экран длину самой длинной последовательности повторяющихся чисел в списке.*/

 public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();

        adding(list);

        System.out.println(sequenceFinder(list));

    }

     private static int sequenceFinder(ArrayList<Integer> list) {
        int longestSequence =0;
        int[] arr = new int[] {1,1,1,1,1,1,1,1,1,1}; //array of sequence length
        int j =0;  //Index for array of sequence length

         for (int i = 0; i < list.size()-1; i++) {
             if (list.get(i).equals(list.get(i+1))) {
                 arr[j]=arr[j] + 1;
             } else {
                 j++;

             }
         }

         Arrays.sort(arr);
        longestSequence = arr[arr.length-1];
        return longestSequence;
     }

     public static ArrayList adding (ArrayList list) throws IOException {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         int num;
         for (int i = 0; i < 10; i++) {
            num = Integer.parseInt(reader.readLine());
             list.add(num);
         }
         return list;
     }

}

