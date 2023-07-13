package com.algorithms.linkedlist;

/**
 * 双向链表节点
 *
 * @author FangYuan
 * @since 2023-07-12 20:20:50
 */
public class DoubleNode<Item> {

    public Item val;

    public DoubleNode<Item> pre;

    public DoubleNode<Item> next;

    public DoubleNode(Item val) {
        this.val = val;
    }


}
