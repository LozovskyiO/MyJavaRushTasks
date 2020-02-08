package com.javarush.task.task14.task1419;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            File f = new File("112.ter");

            BufferedReader reader = new BufferedReader(new FileReader(f));

        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.close();
            reader.readLine();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] arr = new int[2];
            int a = arr[4];
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = null;
            String k = s.toLowerCase();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = "2wf";
            Integer i = Integer.parseInt(s);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Socket socket = new Socket("0d.52.2.3", 54);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int i = -2;
            int[] k = new int[i];

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String s = "123";
            char c = s.charAt(5);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object x = new Integer(0);
            System.out.println((String)x);
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
