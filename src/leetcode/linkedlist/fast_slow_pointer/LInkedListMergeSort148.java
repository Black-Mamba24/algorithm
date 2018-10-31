package leetcode.linkedlist.fast_slow_pointer;

import leetcode.ListNode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 思路：归并排序。链表在折半时可以利用109号题目的技巧，将记录slow前一个节点，且第一条链的结尾指向null
 * 递归操作执行折半，合并时不能将一个链表合并到另一个链表，需要一个指针，通过通过改变指针指向，重新建立链表。
 * 链表只需要头结点，无需存储所有节点的特性帮助减少空间复杂度为常数。
 * 一定注意链表折半，不要使用start、end方式，会增加代码复杂性，且start、end的前后、是否非空需要多种判断。
 * Created by zhaiyi on 2018/10/23.
 */
public class LInkedListMergeSort148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode slow, fast, last;
            slow = fast = last = head;
            while (fast != null && fast.next != null) {
                last = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            last.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(slow);
            return merge(left, right);
        }
    }


    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode res, tmp;
        if (list1.val < list2.val) {
            res = tmp = list1;
            list1 = list1.next;
        } else {
            res = tmp = list2;
            list2 = list2.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;
                tmp = tmp.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
                tmp = tmp.next;
            }
        }

        ListNode list = list1 == null ? list2 : list1;
        while (list != null) {
            tmp.next = list;
            list = list.next;
            tmp = tmp.next;
        }
        return res;
    }
}