package com.javarush.task.task08.task0824;

/* 
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).


Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.*/

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        Human son1 = new Human("Sasha", true, 12);
        Human son2 = new Human("Vasja", true, 12);
        Human son3 = new Human("Kolja", true, 12);

        ArrayList<Human> children1 = new ArrayList<>();
        children1.add(son1);
        children1.add(son2);
        children1.add(son3);

        Human father = new Human("Sergiy", true, 48, children1);
        Human mother = new Human("Valentina", false, 42, children1);

        ArrayList<Human> children2 = new ArrayList<>();
        children2.add(father);

        ArrayList<Human> children3 = new ArrayList<>();
        children3.add(mother);

        Human grandFather1 = new Human("Ivan", true, 74, children2);
        Human grandFather2 = new Human("Valera", true, 64, children3);

        Human grandMother1 = new Human("Luda", false, 73, children2);
        Human grandMother2 = new Human("Ira", false, 73, children3);

        ArrayList<Human> humans = new ArrayList<>();
        humans.add(grandFather1);
        humans.add(grandFather2);
        humans.add(grandMother1);
        humans.add(grandMother2);
        humans.add(father);
        humans.add(mother);
        humans.add(son1);
        humans.add(son2);
        humans.add(son3);

        for (Human h :
                humans) {
            System.out.println(h);
        }

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
