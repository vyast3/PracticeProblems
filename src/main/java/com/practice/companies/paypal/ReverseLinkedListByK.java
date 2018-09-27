package com.practice.companies.paypal;

public class ReverseLinkedListByK {

    public LinkedListNode reverseListKGroup(LinkedListNode head, int k) {
        if (k == 1) return head;
        LinkedListNode curr = head;
        // Check if list contains k elements, if not then return head as is
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                return head;
            }
            curr = curr.next;
        }
        //reverse k nodes from head
        LinkedListNode newHead = reverseList(head, k);
        // reverse remaining k elements recursively
        head.next = reverseListKGroup(curr, k);
        return newHead;
    }

    /**
     * Reverses k nodes in list
     */
    private LinkedListNode reverseList(LinkedListNode head, int k) {
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        int count = 0;
        while (curr != null && count < k) {
            LinkedListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        return prev;
    }

    private class LinkedListNode<T> {
        public T data;
        public LinkedListNode next;
    }
}
