package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode0021 {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void test() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode result = mergeTwoLists(list1, list2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode head = result;
        while (list1 != null && list2 != null) {
            if (result.next == null) {
                result.next = new ListNode();
            }
            if (list1.val >= list2.val) {
                result.next.val = list2.val;
                list2 = list2.next;
            } else {
                result.next.val = list1.val;
                list1 = list1.next;
            }
            result = result.next;
        }
        if (list1 != null) {
            result.next = list1;
        }
        if (list2 != null) {
            result.next = list2;
        }
        return head.next;
    }
}
