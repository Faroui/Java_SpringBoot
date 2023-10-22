package com.ds;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkingWithList {
    public static void main(String[] args) {
        List<Object> numbers = new ArrayList<>();
        ArrayList<String> jobs=new ArrayList<>();
        List<String> mathUnmodifiable=List.of(
                "Analysis",
                "Algebra",
                "Probability",
                "Statistic"
        );
        jobs.add("Software Engineer");
        jobs.add("Mathematicians");
        numbers.add(67);
        numbers.add(90);
        numbers.add("Hello World");
        numbers.add(jobs);
        numbers.forEach(System.out::println);
        mathUnmodifiable.forEach(System.out::println);
    }
}
