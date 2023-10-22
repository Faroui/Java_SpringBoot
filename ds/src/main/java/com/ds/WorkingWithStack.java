package com.ds;

import java.util.Stack;

public class WorkingWithStack {
    public static void main(String[] args) {
        Stack<Integer> unStack= new Stack<>();
        unStack.push(9);
        unStack.push(90);
        unStack.push(8);
        unStack.push(7);
        //int i=unStack.firstElement();
        System.out.println(unStack.peek());
    }
}
