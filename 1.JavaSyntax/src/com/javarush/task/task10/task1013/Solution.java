package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String eyecolor;
        private int age;
        private int height;
        private float weight;
        private byte strength;

        public Human(String name, String eyecolor, int age, int height, float weight, byte strength) {
            this.name = name;
            this.eyecolor = eyecolor;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.strength = strength;
        }

        public Human(String name, String eyecolor, int age, int height, float weight) {
            this.name = name;
            this.eyecolor = eyecolor;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, String eyecolor, int age, int height) {
            this.name = name;
            this.eyecolor = eyecolor;
            this.age = age;
            this.height = height;
        }

        public Human(String name, String eyecolor, int age) {
            this.name = name;
            this.eyecolor = eyecolor;
            this.age = age;
        }

        public Human(String name, String eyecolor) {
            this.name = name;
            this.eyecolor = eyecolor;
        }

        public Human(String name, int age, float weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public Human(String name, float weight, byte strength) {
            this.name = name;
            this.weight = weight;
            this.strength = strength;
        }

        public Human(int age, int height, float weight) {
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, String eyecolor, float weight) {
            this.name = name;
            this.eyecolor = eyecolor;
            this.weight = weight;
        }

        public Human(int age, int height, float weight, byte strength) {
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.strength = strength;
        }
    }

}
