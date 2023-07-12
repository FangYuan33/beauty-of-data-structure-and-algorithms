package com.algorithms.linkedlist;

/**
 * 双向链表工具类
 *
 * @author FangYuan
 * @since 2023-07-12 21:16:02
 */
public class DoubleNodeUtil {

    /**
     * 打印双端链表结果
     */
    public static void print(DoubleNode node) {
        StringBuilder res = new StringBuilder("null <-> ");

        while (node != null) {
            res.append(node.val).append(" <-> ");
            node = node.next;
        }
        // 拼接尾巴节点
        res.append("null");

        System.out.println(res);
    }

    /**
     * 获取指定长度的链表
     *
     * @param length     指定长度
     * @param beginValue 起始值
     */
    public static DoubleNode getFixLengthDoubleNode(Integer length, Integer beginValue) {
        if (length <= 0) {
            return null;
        }

        DoubleNode pre = new DoubleNode(0);
        DoubleNode beginNode = new DoubleNode(beginValue++);
        pre.next = beginNode;

        while (--length != 0) {
            DoubleNode node = new DoubleNode(beginValue++);
            beginNode.next = node;
            node.pre = beginNode;

            beginNode = beginNode.next;
        }

        return pre.next;
    }
}
