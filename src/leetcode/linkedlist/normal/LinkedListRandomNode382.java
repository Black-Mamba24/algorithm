package leetcode.linkedlist.normal;

import java.util.Random;
import leetcode.ListNode;

/**
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。

 进阶:
 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 * Created by zhaiyi on 2019/2/16.
 */
public class LinkedListRandomNode382 {
    //    private Random random = new Random();
//    private ListNode head;
//    private int len;
//
//    public LinkedListRandomNode382(ListNode head) {
//        this.head = head;
//        ListNode tmp = head;
//        while (tmp != null) {
//            len++;
//            tmp = tmp.next;
//        }
//    }
//
//    /** Returns a random node's value. */
//    public int getRandom() {
//        int pos = random.nextInt(len);
//        int cur = 0;
//        ListNode tmp = head;
//        while (cur != pos) {
//            cur++;
//            tmp = tmp.next;
//        }
//        return tmp.val;
//    }
    private ListNode head;
    private Random random = new Random();

    public LinkedListRandomNode382(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int count = 0;
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            if (random.nextInt(count++) == 0) {
                res = cur.val;
            }
            cur = cur.next;
        }
        return res;
    }
}
