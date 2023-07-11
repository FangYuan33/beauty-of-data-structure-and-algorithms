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
}
