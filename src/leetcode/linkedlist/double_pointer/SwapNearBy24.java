package leetcode.linkedlist.double_pointer;

import leetcode.ListNode;
/**
 *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.
 说明:

 你的算法只能使用常数的额外空间。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 思路：1. 增加头结点
 2，使用三个指针，如果交换1、2节点，先暂存3节点，因为改变2的next。
 3. 要交换两个节点，必须有前一个节点的引用。因此确定首尾两个指针+中间一个指针。
 * Created by zhaiyi on 2018/10/21.
 */
public class SwapNearBy24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = swapPairs(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode f = new ListNode(0);
        ListNode s = head, t = head.next.next, res = f;
        //交换s和s.next
        while (true) {
            f.next = s.next;
            f = f.next;
            f.next = s;
            s.next = t;
            if (t == null || t.next == null) {
                break;
            } else {
                t = t.next.next;
                s = s.next;
                f = f.next;
            }
        }
        return res.next;
    }
}
