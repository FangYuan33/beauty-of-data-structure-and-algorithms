package com.algorithms.stack;

import com.algorithms.linkedlist.ListNode;
import com.algorithms.ListNodeUtil;

/**
 * 支持 push pop dequeue 操作的数据结果
 *
 * @author FangYuan
 * @since 2023-07-12 21:44:32
 */
public class Steque {

    public static void main(String[] args) {
        Steque steque = new Steque();

        steque.push(1);
        steque.enqueue(0);
        steque.push(2);
        ListNodeUtil.print(steque.head);

        System.out.println(steque.pop());
        System.out.println(steque.pop());
        System.out.println(steque.pop());
    }

    private ListNode<Integer> head;

    private ListNode<Integer> tail;

    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 尾插法
     */
    public void push(int val) {
        if (isEmpty()) {
            head = new ListNode<>(val);
            tail = head;
        } else {
            tail.next = new ListNode<>(val);
            tail = tail.next;
        }

        size++;
    }

    /**
     * 头插法
     */
    public void enqueue(int val) {
        if (isEmpty()) {
            head = new ListNode<>(val);
            tail = head;
        } else {
            ListNode<Integer> newHead = new ListNode<>(val);
            newHead.next = head;
            head = newHead;
        }

        size++;
    }

    /**
     * 出去
     */
    public Integer pop() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            int result = head.val;
            head = null;
            tail = null;
            size--;

            return result;
        } else {
            ListNode<Integer> node = head;
            while (node.next.next != null) {
                node = node.next;
            }
            int result = node.next.val;
            node.next = null;
            size--;

            return result;
        }
    }
}
