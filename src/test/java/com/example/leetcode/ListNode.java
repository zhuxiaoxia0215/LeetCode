package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode node) {
        val = x;
        next = node;
    }

    public static ListNode arrayToListNode(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode pre = head;
        for (int i = 0; i < nums.length; i++) {
            pre.val = nums[i];
            if (i == nums.length - 1) {
                pre.next = null;
            } else {
                pre.next = new ListNode();
                pre = pre.next;
            }
        }
        return head;
    }

    public static String toString(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return Arrays.toString(list.toArray());
    }

}
