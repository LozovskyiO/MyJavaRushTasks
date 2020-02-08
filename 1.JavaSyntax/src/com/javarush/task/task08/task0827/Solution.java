package com.javarush.task.task08.task0827;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате FEBRUARY 1 2013
Не забудьте учесть первый день года.

Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false


Требования:
1. Программа должна выводить текст на экран.
2. Класс Solution должен содержать два метода.
3. Метод isDateOdd() должен возвращать true, если количество дней с начала года - нечетное число, иначе false.
4. Метод main() должен вызывать метод isDateOdd().*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));

    }

    public static boolean isDateOdd(String date) {
        Calendar da = new GregorianCalendar();
        String[] dataArrayed = date.split("\\s");

        int number=0;
        switch(dataArrayed[0]) {

            case "JANUARY": number=0;
                break;
            case "FEBRUARY": number=1;
                break;
            case "MARCH": number=2;
                break;
            case "APRIL": number=3;
                break;
            case "MAY": number=4;
                break;
            case "JUNE": number=5;
                break;
            case "JULY": number=6;
                break;
            case "AUGUST": number=7;
                break;
            case "SEPTEMBER": number=8;
                break;
            case "OCTOBER": number=9;
                break;
            case "NOVEMBER": number=10;
                break;
            case "DECEMBER": number=11;
                break;
        }
        da.set(Calendar.MONTH,number);
        da.set(Calendar.YEAR,Integer.parseInt(dataArrayed[2]));
        da.set(Calendar.DAY_OF_MONTH,Integer.parseInt(dataArrayed[1]));

        int dayNumber= da.get(Calendar.DAY_OF_YEAR);

        if(dayNumber%2!=0) { return true;
        } else return false;
    }




}
