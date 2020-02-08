package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
В методе main добавить в статический объект list 5 нитей. Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.


Требования:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Метод run класса SpecialThread должен выводить "it's a run method inside SpecialThread".*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread specialThreadthread1 = new SpecialThread();
        SpecialThread specialThreadthread2 = new SpecialThread();
        SpecialThread specialThreadthread3 = new SpecialThread();
        SpecialThread specialThreadthread4 = new SpecialThread();
        SpecialThread specialThreadthread5 = new SpecialThread();

        Thread thread1 = new Thread(specialThreadthread1);
        Thread thread2 = new Thread(specialThreadthread2);
        Thread thread3 = new Thread(specialThreadthread3);
        Thread thread4 = new Thread(specialThreadthread4);
        Thread thread5 = new Thread(specialThreadthread5);

        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
        list.add(thread5);

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
