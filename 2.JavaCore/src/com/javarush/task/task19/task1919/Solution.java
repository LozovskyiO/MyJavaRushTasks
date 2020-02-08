package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        StringBuilder stringBuilder = new StringBuilder();
        List<String> listOfLines = new ArrayList<>();
        Map<String, Double> mapOfLines = new TreeMap<String, Double>(String.CASE_INSENSITIVE_ORDER);

        TreeMap<String, Double> map = new TreeMap<>();
        while (bufferedReader.ready()) {
            String[] strings = bufferedReader.readLine().split(" ");
            map.put(strings[0], (map.containsKey(strings[0]) ? map.get(strings[0]) + Double.parseDouble(strings[1]) : Double.parseDouble(strings[1])));
        }

        bufferedReader.close();

        bufferedReader.close();
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
