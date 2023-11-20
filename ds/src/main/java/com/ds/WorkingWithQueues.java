package com.ds;

import java.util.LinkedList;
import java.util.Queue;

public class WorkingWithQueues {
    public static void main(String[] args) {
        Queue<Person> supermarket = new LinkedList<>();
        supermarket.add(new Person("ismail",30));
        supermarket.add(new Person("Mariam",2));
        supermarket.add(new Person("Imane",28));
        supermarket.poll();
        System.out.println(supermarket.size());
    }
    static record Person(String name,int age){}
}


