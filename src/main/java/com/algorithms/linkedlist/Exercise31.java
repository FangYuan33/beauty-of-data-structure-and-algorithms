package com.algorithms.linkedlist;

public class Exercise31 {

    public static void main(String[] args) {
        Exercise31 exercise31 = new Exercise31();
        exercise31.insertAtTheBeginning(1);
        exercise31.insertAtTheEnding(2);
        exercise31.insertAtTheEnding(3);
        exercise31.insertAtTheBeginning(4);
        DoubleNodeUtil.print(exercise31.head);

        exercise31.removeHead();
        exercise31.removeTail();
        DoubleNodeUtil.print(exercise31.head);

        exercise31.insertAfter(2, 3);
        exercise31.insertBefore(1, 0);
        DoubleNodeUtil.print(exercise31.head);

        exercise31.deleteNode(0);
        exercise31.deleteNode(2);
        DoubleNodeUtil.print(exercise31.head);
    }

    private DoubleNode<Integer> head;

    private DoubleNode<Integer> tail;

    private int size;

    public Exercise31() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 在链表头插入节点
     */
    public void insertAtTheBeginning(Integer val) {
        DoubleNode<Integer> node = new DoubleNode<>(val);
        if (isEmpty()) {
            // 空的话
            head = node;
            tail = head;
        } else {
            // 非空的话
            head.pre = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * 在链表尾插入节点
     */
    public void insertAtTheEnding(Integer val) {
        DoubleNode<Integer> node = new DoubleNode<>(val);
        if (isEmpty()) {
            tail = node;
            head = tail;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size++;
    }

    /**
     * 移除头节点
     */
    public void removeHead() {
        if (size == 0) {
            return;
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else if (size > 1) {
            head = head.next;
            head.pre = null;
        }
        size--;
    }

    /**
     * 移除尾巴节点
     */
    public void removeTail() {
        if (size == 0) {
            return;
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else if (size > 1) {
            tail = tail.pre;
            tail.next = null;
        }
        size--;
    }

    /**
     * 在指定节点前插入
     */
    public void insertBefore(int specific, int insertVal) {
        DoubleNode<Integer> node = head;
        while (node != null) {
            if (node.val == specific) {
                if (node.pre == null) {
                    // 在头结点插入
                    insertAtTheBeginning(insertVal);
                } else {
                    DoubleNode<Integer> insertNode = new DoubleNode<Integer>(insertVal);
                    DoubleNode<Integer> preNode = node.pre;

                    // 构建双链表关联关系
                    preNode.next = insertNode;
                    insertNode.pre = preNode;
                    insertNode.next = node;
                    node.pre = insertNode;
                }
                break;
            }

            node = node.next;
        }
    }

    /**
     * 在指定节点后插入
     */
    public void insertAfter(int specific, int insertVal) {
        DoubleNode<Integer> node = head;
        while (node != null) {
            if (node.val == specific) {
                if (node.next == null) {
                    // 在尾巴节点插入
                    insertAtTheEnding(insertVal);
                } else {
                    DoubleNode<Integer> insetNode = new DoubleNode<>(insertVal);
                    DoubleNode<Integer> nextNode = node.next;

                    // 构建双链表关系
                    insetNode.next = nextNode;
                    nextNode.pre = insetNode;
                    node.next = insetNode;
                    insetNode.pre = node;
                }

                break;
            }

            node = node.next;
        }
    }

    /**
     * 移除指定节点
     */
    public void deleteNode(int specific) {
        if (isEmpty()) {
            return;
        }

        if (head.val == specific) {
            removeHead();
            return;
        }
        if (tail.val == specific) {
            removeTail();
            return;
        }

        // 非空且不是头尾节点，遍历找找试试
        DoubleNode<Integer> node = head.next;
        while (node != null) {
            if (node.val == specific) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                break;
            }

            node = node.next;
        }
    }
}
