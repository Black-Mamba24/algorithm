package leetcode.linkedlist.recursion;

import leetcode.ListNode;

/**
 * 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 * Created by zhaiyi on 2018/9/6.
 */
public class ReverseLinkedList {
    public ListNode tmp = null, result = null;

    //入口
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        reverse(head);
        return result;
    }

    //递归
    public void reverse(ListNode head) {
        if (head.next == null) {
            build(head.val);
        } else {
            reverse(head.next);
            build(head.val);
        }
    }

    //创建新链表
    public void build(int val) {
        if (tmp == null) {
            tmp = new ListNode(val);
            result = tmp;
        } else {
            tmp.next = new ListNode(val);
            tmp = tmp.next;
        }
    }
}
