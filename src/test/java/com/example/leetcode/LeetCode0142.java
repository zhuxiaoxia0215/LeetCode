package com.example.leetcode;

import java.util.HashMap;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 */
public class LeetCode0142 {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Integer> index = new HashMap();
        while (head != null) {
            if (index.containsKey(head)) {
                return head;
            }
            index.put(head, 0);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        if (head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return null;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (slow != null && fast.next != null) {
            if (slow == fast) {
                ListNode pre = head;
                while (pre != slow) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}
