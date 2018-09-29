package leetcode.linkedlist.double_pointer;

import leetcode.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

 示例 1:

 输入: 1->2->3->4->5->NULL
 输出: 1->3->5->2->4->NULL
 * Created by zhaiyi on 2018/9/28.
 */
public class OddEvent328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, odd_tmp = odd, even = head.next, even_tmp = even;
        while (even_tmp != null && even_tmp.next != null && odd_tmp != null && odd_tmp.next != null) {
            odd_tmp.next = even_tmp.next;
            odd_tmp = odd_tmp.next;

            even_tmp.next = odd_tmp.next;
            even_tmp = even_tmp.next;
        }
        odd_tmp.next = even;
        return odd;
    }
}
