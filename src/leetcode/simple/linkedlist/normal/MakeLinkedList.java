package leetcode.simple.linkedlist.normal;

import leetcode.ListNode;

/**
 * Created by zhaiyi on 2018/9/10.
 */
public class MakeLinkedList {
    ListNode head = null, tail = null;
    int len = 0;

    public static void main(String[] args) {
        MakeLinkedList makeLinkedList = new MakeLinkedList();
        makeLinkedList.addAtHead(1);
        makeLinkedList.addAtTail(3);
        makeLinkedList.deleteAtIndex(1);
        System.out.println(makeLinkedList.get(0));
        makeLinkedList.deleteAtIndex(0);
        System.out.println(makeLinkedList.get(0));

    }

    /** Initialize your data structure here. */
    public MakeLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode tmp = head;
        int i = 0;
        while (tmp != null) {
            if (i == index) {
                return tmp.val;
            }
            i++;
            tmp = tmp.next;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        head = newHead;
        len++;
        if(tail == null) {
            tail = newHead;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (tail == null) {
            tail = new ListNode(val);
            head = tail;
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        len++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead (val);
        } else if (index == len) {
            addAtTail(val);
        } else if (index > 0 && index < len) {
            int i = 0;
            ListNode tmp = head;
            while (i < index - 1) {
                tmp = tmp.next;
                i++;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = tmp.next;
            tmp.next = newNode;
            len++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (len > 0) {
            if (index == 0) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
                len--;
            } else if (index <= len - 1) {
                int i = 0;
                ListNode tmp = head;
                while (i < index - 1) {
                    tmp = tmp.next;
                    i++;
                }
                tmp.next = tmp.next.next;
                if (tmp.next == null) {
                    tail = tmp;
                }
                len --;
            }
        }
    }
}
