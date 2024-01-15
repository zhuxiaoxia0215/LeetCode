package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false
 */
public class LeetCode0234 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Object[] val = list.toArray();
        int left = 0, rigth = val.length-1;
        while (left < rigth) {
            if (val[left] != val[rigth]) {
                return false;
            }
            left++;
            rigth--;
        }
        return true;
    }
}
