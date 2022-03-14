package com.company;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        System.out.println(list.size());
        list.addLast(10);
        System.out.println(list.size());
        list.addLast(20);
        System.out.println(list.size());
        list.addLast(30);
        System.out.println(list.size());
    }
}
