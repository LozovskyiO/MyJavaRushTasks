package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву "р"
2.2. удваивать все слова содержащие букву "л".
2.3. если слово содержит и букву "р" и букву "л", то оставить это слово без изменений.
2.4. с другими словами ничего не делать.

Пример:
роза
лира
лоза

Выходные данные:
лира
лоза
лоза


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод fix должен удалять из списка строк все слова, содержащие букву "р". Исключение: слова содержащие и букву "р" и букву "л" - их нужно оставить.
3. Метод fix должен удваивать слова, содержащие букву "л" (добавлять еще один элемент с этим словом). Исключение: слова содержащие и букву "л" и букву "р" - их не нужно удваивать.
4. Метод fix не должен ничего делать со словами, содержащими и букву "л" и букву "р".
5. Метод fix не должен ничего делать со словами, которые не содержат ни букву "л", ни букву "р".*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); // 0
        list.add("лоза"); // 1
        list.add("лира"); // 2
        list.add("ила"); // 2
        list.add("имра"); // 2
        list.add("има"); // 2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        String temp;
        boolean flagToDelete = false, flagToDouble = false;

        int size = list.size();

        for (int i = 0; i < size; ) {
            temp = list.get(i);
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == 'р') {
                    flagToDelete = true;
                }
                else if (temp.charAt(j) =='л') {
                    flagToDouble = true;
                }
            }
            if (flagToDelete && !flagToDouble ) {
                list.remove(i);
                size = size - 1;
                flagToDelete = false;


            } else if (!flagToDelete && flagToDouble) {
                list.add(i+1, temp);
                size = size + 1;
                i = i + 2;
                flagToDouble = false;

            } else {
                i++;
                flagToDouble = false;
                flagToDelete = false;
            }
        }
        return list;
    }
}