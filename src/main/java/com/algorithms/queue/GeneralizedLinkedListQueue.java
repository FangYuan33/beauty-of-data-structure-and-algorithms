package com.algorithms.queue;

import com.algorithms.linkedlist.ListNode;

/**
 * 可以指定删除最早插入的第K个元素
 * 链表实现
 * 思路：直接将某个节点移除即可
 *
 * @author FangYuan
 * @since 2023-07-17 15:04:37
 */
public class GeneralizedLinkedListQueue<Item> {

    public static void main(String[] args) {
        GeneralizedLinkedListQueue<Integer> queue = new GeneralizedLinkedListQueue<>();

        for (int i = 0; i < 5; i++) {
            queue.insert(i);
        }

        System.out.println(queue.delete(2));
        System.out.println(queue.delete(2));
        System.out.println(queue.delete(2));
        System.out.println(queue.delete(2));
        System.out.println(queue.delete(2));

        for (int i = 0; i < 5; i++) {
            queue.insert(i);
        }

        System.out.println(queue.delete(2));
        System.out.println(queue.delete(2));
        System.out.println(queue.delete(2));
        System.out.println(queue.delete(2));
        System.out.println(queue.delete(2));
    }

    private ListNode<Item> head;

    private int size;

    public GeneralizedLinkedListQueue() {
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 如果采用头插法的话，那么最先插入的在尾部，删除第K个需要找到倒数第K个，
     * 遍历找到倒数第K个节点的前一个节点需要循环 size - 1 - k 次
     */
    public void insert(Item val) {
        ListNode<Item> node = new ListNode<>(val);
        if (isEmpty()) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }

        size++;
    }

    public Item delete(int k) {
        if (k <= 0) {
            return null;
        }

        while (k > size) {
            k -= size;
        }

        Item res;
        if (k == size) {
            res = head.val;
            head = head.next;
            size--;

            return res;
        } else {
            ListNode<Item> current = head;
            int step = size - 1 - k;

            // 找到要删除链表的前一个节点
            while (step != 0) {
                step--;
                current = current.next;
            }
            res = current.next.val;
            // 删除节点
            current.next = current.next.next;
            size--;

            return res;
        }
    }
}
