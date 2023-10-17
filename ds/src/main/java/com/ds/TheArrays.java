package com.ds;

import java.util.Arrays;

public class TheArrays {
    public static void main(String[] args) {
        String[] colors=new String[5];
        colors[0] = "black";
        colors [4] ="white";
        Arrays.stream(colors).forEach(System.out::println);
        //System.out.println(Arrays.toString(colors));
    }
}
