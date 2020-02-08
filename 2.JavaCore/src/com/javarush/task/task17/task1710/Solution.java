package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
CrUD - Create, Update, Delete.

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


Требования:
1. Класс Solution должен содержать public static поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat sf = new SimpleDateFormat("d/MM/y");

        switch(args[0]){
            case "-c":
                if(args[2].equals("м")) allPeople.add(Person.createMale(args[1], sf.parse(args[3])));
                if(args[2].equals("ж")) allPeople.add(Person.createFemale(args[1], sf.parse(args[3])));
                System.out.println(allPeople.size()-1);
                break;
            case "-u":
                updatePerson(args);
                break;
            case "-d":
                logicDeletingPerson(Integer.parseInt(args[1]));
                break;
            case "-i":
                displayingPerson(Integer.parseInt(args[1]));
                break;
        }



//        SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//        for (Person p :
//                allPeople) {
//            if (args[0].equals("-d")) {System.out.println(p.getName()+ " " + null + " " + null);}
//            else System.out.println(p.getName()+ " " + (p.getSex().equals(Sex.MALE)? "м": "ж") + " " + sf.format(p.getBirthDate()));
//        }
    }

    public static void updatePerson(String[] params) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("d/MM/y");
        //System.out.println("before " + allPeople.size());
        Person updPerson = allPeople.get((Integer.parseInt(params[1])));
        updPerson.setName(params[2]);
        updPerson.setSex(params[3].equals("м")? Sex.MALE: Sex.FEMALE);
        updPerson.setBirthDate(sf.parse(params[4]));
        //System.out.println("aft " + allPeople.size());

    }

    public static void logicDeletingPerson(int id){
        Person updPerson = allPeople.get(id);
        updPerson.setName(null);
        updPerson.setSex(null);
        updPerson.setBirthDate(null);

        allPeople.set(id, updPerson);
    }

    public static void displayingPerson(int id){
        SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(allPeople.get(id).getName()+ " " + (allPeople.get(id).getSex().equals(Sex.MALE)? "м": "ж") + " " + sf.format(allPeople.get(id).getBirthDate()));
    }

}
//(a < 5) ? 9.9 : 9)