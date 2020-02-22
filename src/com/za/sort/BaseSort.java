package com.za.sort;

public abstract class BaseSort {

    public void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public void listOf(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public void print(String s) {
        System.out.println(s);
    }

    public abstract void sort(int[]data);
}
