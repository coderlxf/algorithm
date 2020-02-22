package com.za.sort;

public class BubbleSort extends BaseSort {
    @Override
    public void sort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            print("i=" + i);
            boolean flag = false;
            for (int j = data.length - 1; j > i; j--) {
                print(">>>>>>j=" + j);
                if (data[j] < data[j - 1]) {
                    int tmp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public void sort2(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            print("i=" + i);
            boolean flag = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                print(">>>>>>j=" + j);
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{3, 1, 2, 4, 5};
        BubbleSort bs = new BubbleSort();
        bs.sort(data);
        bs.listOf(data);
        data = new int[]{3, 1, 2, 4, 5};
        bs.sort2(data);
        bs.listOf(data);
    }
}
