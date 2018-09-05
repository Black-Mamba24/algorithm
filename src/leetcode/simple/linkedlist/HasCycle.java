package leetcode.simple.linkedlist;

import leetcode.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。

 进阶：
 你能否不使用额外空间解决此题？
 思路：如果有环，快指针一定能套圈慢指针
 * Created by zhaiyi on 2018/8/31.
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
