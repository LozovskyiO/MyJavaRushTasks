package com.javarush.task.task18.task1823;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/* 
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = null;
            while(!(s=reader.readLine()).equals("exit")){
                new ReadThread(s).start();
            }
            reader.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static class ReadThread extends Thread {
       private String filePath;
        public ReadThread(String fileName) {
            this.filePath = fileName;
        }
        public void run(){
            Map<Integer, Integer> map = new HashMap<>();
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
                int i = 0;
                while ((i = bufferedInputStream.read()) != -1){
                    if (map.containsKey(i)) {
                        map.put( i, map.get(i)+1);
                    } else {
                        map.put(i, 1);
                    }
                }
                bufferedInputStream.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            Integer max = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
            resultMap.put(filePath, max);

        }
    }
}

