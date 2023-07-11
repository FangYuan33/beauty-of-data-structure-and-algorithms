package com.algorithms.linkedlist;

/**
 * 链表课后练习26
 *
 * @author FangYuan
 * @since 2023-07-11 20:30:30
 */
public class Exercise26 {

    public static void main(String[] args) {
        ListNode node = ListNodeUtil.getFixLengthListNode(3, 1);
        ListNode node1 = ListNodeUtil.getFixLengthListNode(3, 1);
        ListNode node2 = ListNodeUtil.getFixLengthListNode(3, 1);

        new Exercise25().insertAfter(node, node1);
        ListNodeUtil.print(node);

        new Exercise25().insertAfter(node, node2);
        ListNodeUtil.print(node);

        ListNode res = new Exercise26().remove(node, 1);

        ListNodeUtil.print(res);
    }

    /**
     * 移除指定值的节点
     */
    private ListNode remove(ListNode listNode, Integer val) {
        if (listNode == null) {
            return null;
        }
        // 从头节点开始删，直到找到第一个不一样的
        while (val.equals(listNode.val)) {
            listNode = listNode.next;
        }

        // 保存下来这个头节点
        ListNode pre = new ListNode(0);
        pre.next = listNode;

        // 循环判断
        while (listNode != null && listNode.next != null) {
            // 如果节点的下一个节点和指定值相等的话需要删掉
            if (val.equals(listNode.next.val)) {
                listNode.next = listNode.next.next;
            }
            listNode = listNode.next;
        }

        return pre.next;
    }
}
