package com.javarush.task.task07.task0724;

/* 
Семейная перепись
Создай класс Human с полями имя(String), пол(boolean), возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.

Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.

Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
...


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
3. Добавить в класс конструктор public Human(String name, boolean sex, int age).
4. Добавить в класс конструктор public Human(String name, boolean sex, int age, Human father, Human mother).
5. Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
6. Выведи созданные объекты на экран.*/

public class Solution {
    public static void main(String[] args) {
        Human ivan = new Human("Ivan", true,75);
        Human valery = new Human("Valery", true,73);
        Human tanya = new Human("Tanya", false,54);
        Human katya = new Human("katya", false,34);

        Human igor = new Human("Ihor", true,23,ivan,tanya);
        Human alex = new Human("Alex", true,13,ivan,tanya);
        Human luda = new Human("Luda", false,19,valery,katya);
        Human anya = new Human("Anya", false,3,valery,katya);
        Human alya = new Human("Alya", false,3,valery,katya);


        System.out.println(ivan.toString());
        System.out.println(valery.toString());
        System.out.println(tanya.toString());
        System.out.println(katya.toString());
        System.out.println(igor.toString());
        System.out.println(alex.toString());
        System.out.println(luda.toString());
        System.out.println(anya.toString());
        System.out.println(alya.toString());
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private  Human mother;

        public Human (String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;

        }

        public Human (String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;

        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}