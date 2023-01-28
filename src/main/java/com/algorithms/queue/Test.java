package com.algorithms.queue;

public class Test {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);

        arrayQueue.poll();

        arrayQueue.offer(1);
        arrayQueue.offer(2);
        arrayQueue.offer(3);
        arrayQueue.offer(4);

        System.out.println(arrayQueue.poll());
        arrayQueue.offer(4);
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());


        arrayQueue.offer(5);
        System.out.println(arrayQueue.poll());
    }
}
