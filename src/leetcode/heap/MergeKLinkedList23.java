package leetcode.heap;

import java.util.PriorityQueue;
import leetcode.ListNode;

/**
 * Created by zhaiyi on 2019/1/3.
 */
public class MergeKLinkedList23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                queue.offer(listNode.val);
                listNode = listNode.next;
            }
        }
        ListNode res, tmp;
        res = tmp = null;
        while (!queue.isEmpty()) {
            if (res == null) {
                res = new ListNode(queue.poll());
                tmp = res;
            } else {
                tmp.next = new ListNode(queue.poll());
                tmp = tmp.next;
            }
        }
        return res;
    }
}
