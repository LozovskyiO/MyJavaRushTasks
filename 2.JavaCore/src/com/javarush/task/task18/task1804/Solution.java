package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameAndPath = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileNameAndPath);

        int minOccurence = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (inputStream.available()>0){
            int data = inputStream.read();
            if (!map.containsKey(data)) {

                map.put(data, 1);

            }
            else {
                map.put(data, map.get(data)+1);
            }

            if (map.get(data)<minOccurence) minOccurence = map.get(data);
        }
        inputStream.close();
        reader.close();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()== minOccurence) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
