package com.algorithms.linkedlist;

/**
 * 链表课后练习30
 *
 * @author FangYuan
 * @since 2023-07-12 12:22:16
 */
public class Exercise30 {

    public static void main(String[] args) {
        ListNodeUtil.print(new Exercise30().reverse1(ListNodeUtil.getFixLengthListNode(5, 1)));
        ListNodeUtil.print(new Exercise30().reverse2(ListNodeUtil.getFixLengthListNode(5, 1)));
    }

    /**
     * 链表反转 迭代法
     */
    public ListNode reverse1(ListNode node) {
        ListNode pre = null;

        while (node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }

        return pre;
    }

    /**
     * 递归法解决
     */
    public ListNode reverse2(ListNode node) {
        // 递归结束条件
        if (node == null) {
            return null;
        }
        // 找到末尾节点
        if (node.next == null) {
            return node;
        }

        // 当前节点的下一个节点
        ListNode next = node.next;
        // 反转当前节点的下一个节点，并得到反转结果
        ListNode reverseNode = reverse2(next);
        // 将当前节点放到反转结果的尾巴节点，即 next 指针指向的尾结点
        next.next = node;
        // 当前节点的下一个节点指向 null
        node.next = null;

        // 返回该反转结果即可
        return reverseNode;
    }
}
