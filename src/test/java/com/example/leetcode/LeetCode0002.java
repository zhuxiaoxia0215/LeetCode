package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class LeetCode0002 {

    @Test
    public void Test() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public class ListNode {
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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode pre = new ListNode(0, result);
        int carry = 0;
        while (l1 != null || l2 != null) {
            result.next = new ListNode();
            result = result.next;
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int temp = num1 + num2 + carry;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            result.val = temp % 10;
            carry = temp / 10;
        }

        if (carry != 0) {
            result.next = new ListNode(carry);
        }
        return pre.next.next;
    }

}
