package leetcode.linkedlist.normal;

import leetcode.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。

 示例:

 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 * Created by zhaiyi on 2018/9/5.
 */
public class DeleteListNode {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val == val) {
                tmp = tmp.next;
            } else {
                break;
            }
        }
        if (tmp == null) {
            return null;
        }
        ListNode pre = tmp, cur = tmp.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = pre.next;
            }
        }
        return tmp;
    }
}
