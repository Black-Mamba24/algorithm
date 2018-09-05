package leetcode.middle.linkedlist;

import leetcode.ListNode;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 思路：跟数组类似，注意进位即可，必须使用36-50的方法，不能用另一个指针指向非空链表
 * Created by zhaiyi on 2018/8/29.
 */
public class TwoLinkedListSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head, result;
        result = head = new ListNode(0);
        int prof = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int tmp = l1.val + l2.val + prof;
                int newV = tmp % 10;
                prof = tmp / 10;
                head.next = new ListNode(newV);
                head = head.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null){
                int tmp = l2.val + prof;
                int newV = tmp % 10;
                prof = tmp / 10;
                head.next = new ListNode(newV);
                head = head.next;
                l2 = l2.next;
            } else {
                int tmp = l1.val + prof;
                int newV = tmp % 10;
                prof = tmp / 10;
                head.next = new ListNode(newV);
                head = head.next;
                l1 = l1.next;
            }

        }
        if (prof == 1) {
            head.next = new ListNode(prof);
        }
        return result.next;
    }
}
