package leetcode.linkedlist.fast_slow_pointer;

import leetcode.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。

 进阶：
 你能否不使用额外空间解决此题？
 思路：明显的快慢指针法
 * Created by zhaiyi on 2018/8/31.
 */
public class HasCycle141 {
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
