package com.algorithms.linkedlist;

/**
 * 链表工具类
 *
 * @author FangYuan
 * @since 2023-07-11 20:02:12
 */
public class ListNodeUtil {

    /**
     * 打印结果
     */
    public static void print(ListNode listNode) {
        StringBuilder res = new StringBuilder();

        while (listNode != null) {
            res.append(listNode.val).append(" -> ");
            listNode = listNode.next;
        }
        // 拼接尾巴节点
        res.append("null");

        // 控制台看看结果
        System.out.println(res);
    }

    /**
     * 获取指定长度的链表
     *
     * @param length     指定长度
     * @param beginValue 起始值
     */
    public static ListNode getFixLengthListNode(Integer length, Integer beginValue) {
        ListNode pre = new ListNode(0);
        ListNode beginNode = new ListNode(beginValue++);
        pre.next = beginNode;

        while (length != 0) {
            length--;

            // 不断的拼接 node 节点
            beginNode.next = new ListNode(beginValue++);
            beginNode = beginNode.next;
        }

        return pre.next;
    }
}
