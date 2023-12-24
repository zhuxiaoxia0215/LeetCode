package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LeetCode0019 {

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
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = removeNthFromEnd1(head, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Queue<Integer> queue = new LinkedList<>();
        ListNode result = new ListNode();
        ListNode pre = result;
        while (head != null) {
            queue.offer(head.val);
            head = head.next;
        }
        while (!queue.isEmpty()) {
            if (queue.size() == n) {
                queue.poll();
            }
            if (queue.size() != 0) {
                result.next = new ListNode();
                result.next.val = queue.poll();
                result = result.next;
            }
        }
        return pre.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        ListNode cur = pre;
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return pre.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        ListNode cur = pre;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.pop();
        prev.next = prev.next.next;
        return pre.next;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy.next, second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
