package com.algorithms.linkedlist;

import com.algorithms.ListNodeUtil;

/**
 * 读取字符串编码值，将已经有的编码值移除后加入表头，采用头插法实现
 *
 * @author FangYuan
 * @since 2023-07-17 16:33:13
 */
public class MoveToFront {

    public static void main(String[] args) {
        MoveToFront moveToFront = new MoveToFront();
        moveToFront.insert("abcba");
        moveToFront.print();
    }

    private ListNode<Character> head;


    public void insert(String s) {
        for (char c : s.toCharArray()) {
            if (head == null) {
                head = new ListNode<>(c);
            } else {
                ListNode<Character> node = new ListNode<>(c);

                // 头节点是该值的话，不变即可
                if (head.val == node.val) {
                    continue;
                } else {
                    // 头节点不是该值，那么需要检查是否已经有这个节点了
                    ListNode<Character> pre = head;
                    ListNode<Character> cur = head;
                    cur = cur.next;

                    // 判断是否有重复的，有重复的删掉这个节点
                    while (cur != null) {
                        if (cur.val == c) {
                            // 删除
                            pre.next = cur.next;
                            break;
                        } else {
                            // 指针继续移动
                            cur = cur.next;
                            pre = pre.next;
                        }
                    }

                    // 已经删掉，那么新节点插入头部即可
                    node.next = head;
                    head = node;
                }
            }
        }
    }

    public void print() {
        ListNodeUtil.print(head);
    }

}
