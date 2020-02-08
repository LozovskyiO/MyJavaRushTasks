package com.javarush.task.task09.task0904;

/* 
Стек-трейс длиной 10 вызовов
Напиши код, чтобы получить стек-трейс длиной 10 вызовов. Метод main изменять нельзя.


Требования:
1. В классе должно быть 10 методов (метод main не учитывать).
2. В переменной stackTraceLength должно получиться значение 10.
3. Каждый метод должен вызывать другой метод.
4. Используй метод Thread.currentThread().getStackTrace().*/

public class Solution {
    public static void main(String[] args) throws Exception {
        StackTraceElement[] ste = method1();
        for (int i = 0; i < ste.length; i++) {
            System.out.println(ste[i].getMethodName());
        }

        int stackTraceLength = method1().length - method10().length + 1;

    }

    public static StackTraceElement[] method1() {

        return method2();
    }

    public static StackTraceElement[] method2() {
        //System.out.println( Thread.currentThread().getStackTrace());
        return method3();
    }

    public static StackTraceElement[] method3() {
        //System.out.println( Thread.currentThread().getStackTrace());
        return method4();
    }

    public static StackTraceElement[] method4() {
        //System.out.println( Thread.currentThread().getStackTrace());
        return method5();
    }

    public static StackTraceElement[] method5() {
        //System.out.println( Thread.currentThread().getStackTrace());
        return method6();
    }

    public static StackTraceElement[] method6() {
        //System.out.println( Thread.currentThread().getStackTrace());
        return method7();
    }

    public static StackTraceElement[] method7() {
        //System.out.println( Thread.currentThread().getStackTrace());
        return method8();
    }

    public static StackTraceElement[] method8() {
        //System.out.println( Thread.currentThread().getStackTrace());
        return method9();
    }

    public static StackTraceElement[] method9() {

        //System.out.println( Thread.currentThread().getStackTrace());
        return method10();
    }

    public static StackTraceElement[] method10() {

        //System.out.println( Thread.currentThread().getStackTrace());
        return Thread.currentThread().getStackTrace();
    }
}
