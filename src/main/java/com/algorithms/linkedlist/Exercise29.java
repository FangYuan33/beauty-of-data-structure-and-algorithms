package com.algorithms.linkedlist;

/**
 * 链表课后习题29
 * 用环形链表实现队列
 *
 * @author FangYuan
 * @since 2023-07-11 21:13:15
 */
public class Exercise29 {

    public static void main(String[] args) {
        Exercise29 queue = new Exercise29();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    /**
     * 队列中元素个数
     */
    private int size = 0;

    ListNode<Integer> last;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 元素入队
     */
    public void enqueue(Integer val) {
        ListNode<Integer> newTail = new ListNode<>(val);

        if (isEmpty()) {
            // 初始化
            last = newTail;
            last.next = last;
        } else {
            // 含有节点的情况
            newTail.next = last.next;
            last.next = newTail;
            // 指针移动
            last = last.next;
        }
        size++;
    }

    /**
     * 元素出队
     */
    public Integer dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            Integer res = last.next.val;
            // 删除该节点
            if (size == 1) {
                last = null;
            } else {
                last.next = last.next.next;
            }
            size--;

            return res;
        }
    }
}
