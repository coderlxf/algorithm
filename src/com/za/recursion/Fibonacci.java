package com.za.recursion;

public class Fibonacci {

    public static int Fibonacci(int n) {
        if (n <= 1) return n;
        int pre = 0;
        int cur = 1;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci结果：" + Fibonacci(4));
    }
}
