package com.za.sort;

public class InsertSort extends BaseSort {

    @Override
    public void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < data[j]) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{3, 1, 2, 4, 5};
        InsertSort is = new InsertSort();
        is.sort(data);
        is.listOf(data);
    }
}
