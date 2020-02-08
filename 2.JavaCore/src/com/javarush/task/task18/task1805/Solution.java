package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameAndPath = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileNameAndPath);

        int maxOccurence = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (inputStream.available()>0){
            int data = inputStream.read();
            if (!map.containsKey(data)) {

                map.put(data, 1);

            }
        }
        inputStream.close();
        reader.close();

        int[] arr = new int[map.size()];
        int i =0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[i] = entry.getKey();
            i++;
        }

        Arrays.sort(arr);

        for (int j :
                arr) {
            System.out.print(j+" ");
        }

    }
}
