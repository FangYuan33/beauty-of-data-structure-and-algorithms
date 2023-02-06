package com.algorithms.deque;

public class Test {
    public static void main(String[] args) {
        LinkedListDeque deque = new LinkedListDeque();

        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);

        // 123
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());


        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);

        // 123
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());


        deque.offerFirst(1);
        deque.offerFirst(2);

        // 1
        System.out.println(deque.pollLast());

        deque.offerLast(3);

        // 3
        System.out.println(deque.pollLast());

        deque.offerFirst(1);
        deque.offerLast(3);

        // 312
        System.out.println(deque.pollLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
    }
}
