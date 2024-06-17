package com.example.leetcode;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class LeetCode0075 {

    public void sortColors(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                a++;
            } else if (nums[i] == 1) {
                b++;
            } else {
                c++;
            }
        }
        int index = 0;
        while (a > 0) {
            nums[index] = 0;
            index++;
            a--;
        }
        while (b > 0) {
            nums[index] = 1;
            index++;
            b--;
        }
        while (c > 0) {
            nums[index] = 2;
            index++;
            c--;
        }
    }
}
