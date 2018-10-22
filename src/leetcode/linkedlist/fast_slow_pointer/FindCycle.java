package leetcode.linkedlist.fast_slow_pointer;

import leetcode.ListNode;

/**
 * 查找链表中环的入口，如果没有环返回null
 *
 * 思路：快慢指针，第一次直到两者相遇，此时快指针套圈了，重置慢指针到头部，快指针也每次走一步，直到两者再次相遇。
 * 注意：第二次相遇之前可能出现永远不相遇的情况，需要判断slow是否等于head，如果是一个完整环，永远不会相遇。
 * Created by zhaiyi on 2018/10/21.
 */
public class FindCycle {
    public static void main(String[] args) {
        FindCycle findCycle = new FindCycle();
        ListNode head = new ListNode(1);
        head.next = head;
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = head.next.next.next;

        System.out.println(findCycle.detectCycle(head));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;

        do {
            if (fast == null || fast.next == null) {
                return null;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        } while (!slow.equals(fast));

        slow = head;
        while (!slow.equals(fast)) {
            slow = slow.next;
            fast = fast.next;
            if (slow.equals(head)) {
                return slow;
            }
        }
        return slow;
    }
}
