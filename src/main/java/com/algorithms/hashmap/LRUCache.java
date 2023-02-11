package com.algorithms.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 最近最少使用(Least Recently Used)缓存
 *
 * @author FangYuan
 * @since 2023-02-11 09:20:00
 */
public class LRUCache {

    private static class LinkedNode {
        public int key;
        public int value;

        public LinkedNode prev;
        public LinkedNode next;

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, LinkedNode> cache = new HashMap<>();
    private int size;
    public int capacity;

    private final LinkedNode head;
    private final LinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        // 哨兵节点
        this.head = new LinkedNode(-1, -1);
        this.tail = new LinkedNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * LRU查找节点，存在的话将该节点移到头节点
     */
    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            removeNode(node);
            addHead(node);

            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;

            removeNode(node);
            addHead(node);
        } else {
            LinkedNode newNode = new LinkedNode(key, value);
            // 容量满了的话，得删掉尾巴节点
            if (size == capacity) {
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
                size--;
            }

            addHead(newNode);
            cache.put(key, newNode);
        }

        size++;
    }

    public void remove(int key) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            size--;
            removeNode(node);
            cache.remove(key);
        }
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addHead(LinkedNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public void print() {
        if (size > 0) {
            StringBuilder res = new StringBuilder("LinkedList: {");
            LinkedNode temp = head.next;
            while (temp.key != -1) {
                res.append(temp.value).append(",");
                temp = temp.next;
            }
            res.replace(res.length() - 1, res.length(), "");
            res.append("}");

            StringBuilder cacheRes = new StringBuilder("Cache: {");
            for (LinkedNode value : cache.values()) {
                cacheRes.append(value.value).append(",");
            }
            cacheRes.replace(cacheRes.length() - 1, cacheRes.length(), "");
            cacheRes.append("}");

            System.out.println(res);
            System.out.println(cacheRes);
        }
    }
}
class Test {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        // -1
        lruCache.print();
        System.out.println(lruCache.get(1));

        // 100
        lruCache.put(100, 100);
        lruCache.print();
        System.out.println(lruCache.get(100));

        // 200
        lruCache.put(200, 200);
        lruCache.print();
        System.out.println(lruCache.get(200));

        // -1
        lruCache.remove(200);
        lruCache.print();
        System.out.println(lruCache.get(200));

        // -1
        lruCache.put(300, 300);
        lruCache.put(400, 400);
        lruCache.put(500, 500);
        lruCache.print();
        System.out.println(lruCache.get(100));
    }
}
