package leetcode.simple.linkedlist;

import leetcode.ListNode;

/**
 * 请判断一个链表是否为回文链表。

 示例 1:
 输入: 1->2
 输出: false

 示例 2:
 输入: 1->2->2->1
 输出: true

 要求时间复杂度O(n)，空间复杂度O(1)

 思路：参考翻转链表的思路，在翻转过程中比较两个指针指向的节点的值，一个正向指针，一个逆向指针。
 * Created by zhaiyi on 2018/9/6.
 */
public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(palindrome.isPalindrome(head));
    }

    ListNode forward = null;
    boolean result = true;

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode backward;
        forward = backward = head;
        invert(backward);
        return result;
    }

    public void invert(ListNode backward) {
        if (backward.next == null) {
            // System.out.printf("forward : %d, backward : %d\n", forward.val, backward.val);
            result &= (forward.val == backward.val);
        } else {
            invert(backward.next);
            forward = forward.next;
            // System.out.printf("forward : %d, backward : %d\n", forward.val, backward.val);
            result &= (forward.val == backward.val);
        }
    }
}
