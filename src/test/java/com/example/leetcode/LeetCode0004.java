package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class LeetCode0004 {

    @Test
    public void test() {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int mid = (m + n) / 2 + 1;
        int i = 0, j = 0, k = 0;
        int[] merge = new int[mid];
        while (k < mid) {
            if (i >= m) {
                merge[k++] = nums2[j++];
                continue;
            }
            if (j >= n) {
                merge[k++] = nums1[i++];
                continue;
            }

            if (nums1[i] <= nums2[j]) {
                merge[k++] = nums1[i++];
            } else {
                merge[k++] = nums2[j++];
            }
        }
        if ((m + n) % 2 == 0) {
            return 1.0 * (merge[mid - 1] + merge[mid - 2]) / 2;
        } else {
            return merge[mid - 1];
        }
    }
}
