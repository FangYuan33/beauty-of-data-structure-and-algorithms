package com.algorithms.deque;

import com.algorithms.linkedlist.DoubleNode;
import com.algorithms.linkedlist.DoubleNodeUtil;

/**
 * 双向链表实现双端队列
 *
 * @author FangYuan
 * @since 2023-07-13 12:16:04
 */
public class LinkedListDeque<Item> {

    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();

        deque.pushLeft(3);
        deque.pushLeft(4);
        deque.pushRight(2);
        deque.pushRight(1);
        DoubleNodeUtil.print(deque.head);

        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
    }

    private DoubleNode<Item> head;

    private DoubleNode<Item> tail;

    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 左端加一个新的元素
     */
    public void pushLeft(Item val) {
        DoubleNode<Item> node = new DoubleNode<>(val);
        if (isEmpty()) {
            pushFirstNode(node);
        } else {
            // 头插法
            node.next = head;
            head.pre = node;
            head = node;
        }

        size++;
    }

    /**
     * 右端加一个新的元素
     */
    public void pushRight(Item val) {
        DoubleNode<Item> node = new DoubleNode<>(val);
        if (isEmpty()) {
            pushFirstNode(node);
        } else {
            // 尾插法
            node.pre = tail;
            tail.next = node;
            tail = tail.next;
        }

        size++;
    }

    /**
     * 加入第一个节点
     */
    private void pushFirstNode(DoubleNode<Item> node) {
        head = node;
        head.next = tail;
        tail = head;
        tail.pre = head;
    }

    /**
     * 弹出左边元素
     */
    public Item popLeft() {
        if (isEmpty()) {
            return null;
        } else {
            Item result = head.val;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.pre = null;
            }
            size--;

            return result;
        }
    }

    /**
     * 弹出右边元素
     */
    public Item popRight() {
        if (isEmpty()) {
            return null;
        } else {
            Item result = tail.val;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.pre;
                tail.next = null;
            }
            size--;

            return result;
        }
    }
}
