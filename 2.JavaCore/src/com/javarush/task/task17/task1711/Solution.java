package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
//        allPeople.add(Person.createMale("Петров1 Петр1", new Date()));  //сегодня родился    id=2
//        allPeople.add(Person.createMale("Петров2 Петр2", new Date()));  //сегодня родился    id=3
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("d/MM/y");
        String[] params = new String[args.length-1];

        for (int i = 0; i < params.length; i++) {
            params[i] = args[i+1];
        }

        switch(args[0]){
            case "-c":
                synchronized (allPeople)
                {
                    addingPersons(params);
                }
                break;
            case "-u":
                synchronized (allPeople)
                {
                    updatePerson(params);
                }
                break;
            case "-d":
                synchronized (allPeople)
                {
                    logicDeletingPerson(params);
                }
                break;
            case "-i":
                synchronized (allPeople)
                {
                    displayingPerson(params);
                }
                break;
        }




//        for (Person p :
//                allPeople) {
//            if (args[0].equals("-d")) {System.out.println(p.getName()+ " " + null + " " + null);}
//            else System.out.println(p.getName()+ " " + (p.getSex().equals(Sex.MALE)? "м": "ж") + " " + sf.format(p.getBirthDate()));
//        }
    }

    public static void addingPersons(String[] params) throws ParseException {
        int length = params.length;
        SimpleDateFormat sf = new SimpleDateFormat("d/MM/y");
        int i = 0;
        while (true) {

            if (i > params.length -1 ) break;
            if (params[i+1].equals("м")) allPeople.add(Person.createMale(params[i],sf.parse(params[i+2])));
            if (params[i+1].equals("ж")) allPeople.add(Person.createFemale(params[i],sf.parse(params[i+2])));
            i = i + 3;
            System.out.println(allPeople.size()-1);
        }

    }

    public static void updatePerson(String[] params) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("d/MM/y");

        for (int i = 0; i < params.length; i=i+4) {
            Person updPerson = allPeople.get((Integer.parseInt(params[i])));
            updPerson.setName(params[i+1]);
            updPerson.setSex(params[i+2].equals("м")? Sex.MALE: Sex.FEMALE);
            updPerson.setBirthDate(sf.parse(params[i+3]));
        }

    }

    public static void logicDeletingPerson(String[] id){

        for (int i = 0; i < id.length; i++) {
            Person updPerson = allPeople.get(Integer.parseInt(id[i]));
            updPerson.setName(null);
            updPerson.setSex(null);
            updPerson.setBirthDate(null);
        }


        //allPeople.set(id, updPerson);
    }

    public static void displayingPerson(String[] id){
        SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (int i = 0; i < id.length; i++) {
            System.out.println(allPeople.get(Integer.parseInt(id[i])).getName()+ " " + (allPeople.get(Integer.parseInt(id[i])).getSex().equals(Sex.MALE)? "м": "ж") + " " + sf.format(allPeople.get(Integer.parseInt(id[i])).getBirthDate()));
        }

    }
}

