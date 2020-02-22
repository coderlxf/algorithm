package com.za;

public class RevolveArray {

    public int revolve(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = (start + end) >> 1;
            if (array[mid] > array[start]) {
                start = mid + 1;
            } else if (array[mid] < array[end]) {
                end = mid;
            } else {
                start++;
            }
        }
        return array[start];
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 1, 2, 3};
        RevolveArray rArray = new RevolveArray();
        int a = rArray.revolve(array);
        System.out.println("数组最小值:" + a);
    }
}
