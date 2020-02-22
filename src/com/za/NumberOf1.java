package com.za;

public class NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = -7;
        NumberOf1 n = new NumberOf1();
        System.out.println(num + "的二进制1的数量：" + n.NumberOf1(num));
    }
}
