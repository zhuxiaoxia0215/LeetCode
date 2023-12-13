package com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class sortTest {

    @Test
    public void Test() {
        int[] a = new int[]{7, 10, 9, 8, 3, 6, 3};
        insert(a);
        System.out.println(Arrays.toString(a));
    }

    //冒泡算法， 每次循环找出最大的数，稳定排序
    public void bubble(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    // 选择排序、每次选择最小的元素，放到已排序部分 不稳定排序
    public void selection(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int s = i; // 标识最小元素的索引
            for (int j = s + 1; j < a.length; j++) {
                if (a[s] > a[j]) {
                    s = j;
                }
                if (s != i) {
                    swap(a, s, i);
                }
            }
        }
    }

    // 插入排序 数组分为已排序和未排序区，从未排序曲中拿到第一个元素，放到已排序区，扩大已排序区域 稳定排序
    public void insert(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int t = a[i]; // 待插入的元素值
            int j = i - 1;
            while (j >= 0) {
                if (t < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
                j--;
            }
            a[j + 1] = t;
        }
    }

    // 快速排序，选择一个基准点，将大于基准点的数据放在同一侧，然后更新基准点的位置 不稳定排序
    public void quick(int[] a, int l, int h) {
        if (l > h) {
            return;
        }
        int p = partition(a, l, h);
        quick(a, l, p - 1);
        quick(a, p + 1, h);
    }

    public int partition(int[] a, int l, int h) {
        int pv = a[h];
        int i = l;
        for (int j = l; j < h; j++) {
            if (a[j] < pv) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, h, i);
        return i;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
