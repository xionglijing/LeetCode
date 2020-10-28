package com.ricoh.leetcode.xlj;

public class AddTwoNumbers {
    /**
     * 两数相加：因为数据采用倒序，如3 4 2 ，实际数为243，借此特性可以模拟竖式相加，
     * 两个链表均从头部开始计算，如果超过10，则将carry进为1，加到下一个节点，模拟进位
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        //高位相加，如果大于10，则进一
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2,new ListNode(4,new ListNode(3)));
        System.out.println(listNode);
        ListNode listNode1 = new ListNode(5,new ListNode(6,new ListNode(4)));
        System.out.println(listNode1);
        ListNode listNode2 = addTwoNumbers(listNode, listNode1);
        System.out.println(listNode2);
    }
}

/**
 * 模拟链表 重写toString()是为了打印数据 ，不重写会打印地址
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }

    /**
     * 可以直接进行当前节点赋值，next赋值
     * @param val
     * @param next
     */
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}