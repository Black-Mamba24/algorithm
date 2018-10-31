package leetcode.linkedlist.fast_slow_pointer;

import leetcode.ListNode;
import leetcode.tree.TreeNode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

 示例:

 给定的有序链表： [-10, -3, 0, 5, 9],

 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 * Created by zhaiyi on 2018/10/23.
 */
public class SortedLinkedListToBST109 {
    public static void main(String[] args) {
        SortedLinkedListToBST109 sortedLinkedListToBST109 = new SortedLinkedListToBST109();
        ListNode listNode = sortedLinkedListToBST109.buildList(new int[]{1,2,3,4,5,6});
        TreeNode res = sortedLinkedListToBST109.sortedListToBST2(listNode);
        sortedLinkedListToBST109.midTraverse(res);
    }

    public ListNode buildList(int[] array) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        for (int a : array) {
            head.next = new ListNode(a);
            head = head.next;
        }
        return tmp.next;
    }

    public void midTraverse(TreeNode node) {
        if (node != null) {
            midTraverse(node.left);
            System.out.print(node.val + " ");
            midTraverse(node.right);
        }
    }
    /* 方法零：链表先转换为数组，再用有序数组构建的方法 */
    /* 方法一：快慢指针，每次计算一半，效率跟方法零相同，更好的快慢指针是方法二 */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return buildBST(head, null);
    }

    public TreeNode buildBST(ListNode start, ListNode end) {
        if (start != null && end == null || start != null && start.val < end.val) {
            ListNode slow = start, fast = start;
            while (fast != null && fast.next != null && !fast.equals(end) && !fast.next.equals(end)) {
                slow = slow.next;
                fast = fast.next.next;
            }
            TreeNode root = new TreeNode(slow.val);
            root.left = buildBST(start, slow);
            root.right = buildBST(slow.next, end);
            return root;
        } else {
            return null;
        }
    }
    /* 方法一 end */

    /* 方法二：快慢指针，每次将左边最后一个元素next设置为null，递归层数少、参数少 */
    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        } else {
            //记录slow前面节点
            ListNode slow = head, fast = head, last = head;
            while (fast != null && fast.next != null) {
                last = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            TreeNode root = new TreeNode(slow.val);
            //精髓操作，截断链表
            last.next = null;
            root.left = sortedListToBST2(head);
            root.right = sortedListToBST2(slow.next);
            return root;
        }
    }
}
