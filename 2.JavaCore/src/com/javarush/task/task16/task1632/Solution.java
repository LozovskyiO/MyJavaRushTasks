package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить "Ура";
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()
* * Требования:
1. Статический блок класса Solution должен создавать и добавлять 5 нитей в список threads.
2. Нити из списка threads не должны стартовать автоматически.
3. Нить 1 из списка threads должна бесконечно выполняться.
4. Нить 2 из списка threads должна выводить "InterruptedException" при возникновении исключения InterruptedException.
5. Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
6. Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться.
7. Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
* */
public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);


    static {
        threads.add(new MyThread1());
        threads.add(new MyThread2());
        threads.add(new MyThread3());
        threads.add(new MyThread4());
        threads.add(new MyThread5());
    }

    public static class MyThread1 extends Thread{
        @Override
        public void run() {
            while(true){}
        }
    }

    public static class MyThread2 extends Thread{
        public void run (){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class MyThread3 extends Thread{
        public void run(){
            while (true){
            try {

                System.out.println("Ура");
                sleep(500);
            } catch (InterruptedException e) {
            }
            }

        }
    }

    public static class MyThread5 extends Thread{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        double sum =0;

        public void run(){
            boolean flag = true;
            while(flag) {
                try {
                    input = reader.readLine();
                    sum = sum + Integer.parseInt(input);
                } catch (Exception e) {
                    flag = false;
                }
            }
            System.out.println(sum);
        }
    }

    public static class MyThread4 extends Thread implements Message{

        public void run() {
            while (!this.isInterrupted()) {  }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static void main(String[] args) {
       threads.get(0).start();

       threads.get(1).start();

       threads.get(2).start();
       threads.get(3).start();
       threads.get(4).start();
    }
}