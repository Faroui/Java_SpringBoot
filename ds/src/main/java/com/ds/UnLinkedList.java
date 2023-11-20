package com.ds;

import java.util.LinkedList;
import java.util.ListIterator;

public class UnLinkedList {
    public static void main(String[] args) {
        LinkedList<Person> uneList=new LinkedList<>();
        uneList.add(new Person("ismail",23));
        uneList.add(new Person("ismail",45));
        ListIterator<Person> personListIterator = uneList.listIterator(1);
        while (personListIterator.hasNext()){
            System.out.println(personListIterator.next());
        }
    }
    record Person(String name,Integer age){};
}
