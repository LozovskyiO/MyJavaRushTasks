package com.javarush.task.task31;

import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args){
        IntStream.range(0, 100000)
                .parallel()
                .filter(x -> x % 10000 == 0)
                .map(x -> x / 10000)
                .forEach(System.out::println);
    }
}

