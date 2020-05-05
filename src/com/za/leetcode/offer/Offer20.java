package com.za.leetcode.offer;

/**
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class Offer20 {
    public boolean isNumber(String s) {
        if (s == null || "".equals(s)) return false;
        if (s.indexOf(".") != s.lastIndexOf(".")) return false;
        if (!validate(s)) return false;
        if (s.indexOf("e") > -1) {
            String[] arr = s.split("e");
            if (arr.length < 2 || arr[1].indexOf(".") > -1 || !validate(arr[0])) return false;
        } else if (s.indexOf("E") > -1) {
            String[] arr = s.split("E");
            if (!validate(arr[0])) return false;
            if (arr.length < 2 || arr[1].indexOf(".") > -1 || !validate(arr[0])) return false;
        }
        return true;
    }

    private boolean validate(String s) {
        s = s.trim();
        if ("".equals(s)) return false;
        if (s.indexOf('-') > 0 || s.indexOf('+') > 0) return false;
        int eNum = 0, sNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9' && eNum <= 1 && sNum <= 1) {
                continue;
            } else if (sNum == 0 && (c == '+' || c == '-')) {
                sNum++;
                continue;
            } else if (eNum == 0 && (c == 'E' || c == 'e')) {
                sNum = 0;
                eNum++;
                continue;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Offer20 o20 = new Offer20();
        String s = "1 ";
        boolean result = o20.isNumber(s);
        System.out.println(result);
    }
}
