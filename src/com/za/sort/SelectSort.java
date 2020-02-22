package com.za.sort;

public class SelectSort extends BaseSort {

    @Override
    public void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int tmp = data[j];
                    data[j] = data[i];
                    data[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{3, 1, 2, 4, 5};
        SelectSort is = new SelectSort();
        is.sort(data);
        is.listOf(data);
    }
}
