package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer,String> map = new HashMap<>();

        while(true){
            String fileName = bufferedReader.readLine();
            if (fileName.equals("end")) {
                break;
            }
            String[] stringTokens = fileName.split("\\.part",2);
            map.put(Integer.parseInt(stringTokens[1]),fileName);
        }
        bufferedReader.close();

        String[] finalFilenameExtractor = map.get(1).split("\\.part", 2);

        Map<Integer, String> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, String> entry :
                map.entrySet()) {
            treeMap.put(entry.getKey(), entry.getValue());
        }

        FileOutputStream outputStream = new FileOutputStream(finalFilenameExtractor[0]);

        for (Map.Entry<Integer, String> entry:
             treeMap.entrySet()){
            String fileName = entry.getValue();
            FileInputStream inputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[1000];
            while (inputStream.available() > 0){
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
           inputStream.close();
        }
        outputStream.close();
    }
}
