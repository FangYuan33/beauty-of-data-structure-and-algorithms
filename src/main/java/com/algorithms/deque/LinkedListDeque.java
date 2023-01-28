package com.algorithms.deque;

public class LinkedListDeque {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(ListNode prev, int val, ListNode next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private ListNode front;

    private ListNode rear;

    private int size = 0;

    public LinkedListDeque() {
        front = null;
        rear = null;
    }

    public void offerFirst(int num) {
        ListNode first = front;
        ListNode newNode = new ListNode(null, num, first);
        front = newNode;
        
        if (first == null) 
            rear = newNode;
        else 
            first.prev = newNode;
        
        size++;
    }

    public void offerLast(int num) {
        ListNode last = rear;
        ListNode newNode = new ListNode(last, num, null);
        rear = newNode;
        
        if (last == null) {
            front = newNode;
        } else {
            last.next = newNode;
        }
        
        size++;
    }

    public Integer pollFirst() {
        if (size != 0) {
            ListNode next = front.next;
            front.next = null;

            int result = front.val;
            front = next;

            if (next == null)
                rear = null;
            else
                next.prev = null;
            size--;

            return result;
        }

        return null;
    }

    public Integer pollLast() {
        if (size != 0) {
            ListNode prev = rear.prev;
            rear.prev = null;

            int result = rear.val;
            rear = prev;

            if (prev == null)
                front = null;
            else
                prev.next = null;
            size--;

            return result;
        }

        return null;
    }

    public Integer peekFirst() {
        return front != null ? front.val : null;
    }

    public Integer peekLast() {
        return rear != null ? rear.val : null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
