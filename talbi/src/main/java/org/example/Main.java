package org.example;

import java.util.*;

public class Main {
    public static int[] duplicate(int[] numbers){
        int tmp;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length;i++){

        }
    }
    public static void main(String[] args) {
        int[] t={9,23,9,9};
        Arrays.stream(duplicate(t)).forEach(System.out::println);
    }
}