package com.algorithms.deque;

@SuppressWarnings("unchecked")
public class ArrayDeque<Item> {

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(5);

        for (int i = 0; i < 10; i++) {
            arrayDeque.pushFirst(i);
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(arrayDeque.pollFirst());
        }

        System.out.println("-----------------------------");

        for (int i = 0; i < 10; i++) {
            arrayDeque.pushLast(i);
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(arrayDeque.pollLast());
        }
    }

    private Item[] nums;
    private int head;
    private int tail;
    private int size;

    public ArrayDeque(int capacity) {
        this.nums = (Item[]) new Object[capacity];
        head = tail = 0;
        size = 0;
    }

    /* 获取双向队列的容量 */
    public int capacity() {
        return nums.length;
    }

    /* 获取双向队列的长度 */
    public int size() {
        return size;
    }

    /* 判断双向队列是否为空 */
    public boolean isEmpty() {
        return size == 0;
    }

    /* 队首入队 */
    public void pushFirst(Item num) {
        resize();

        size++;
        // 队首指针先向队首移动一位，越过队首后，通过取余操作返回到队尾
        head = (head - 1 + capacity()) % capacity();
        // 队首前添加num，这里与从队尾进行操作的方法需要区分：队尾操作是先添加num，再进行指针移动，如果都是先移动、再添加则会产生值覆盖的情况
        nums[head] = num;
    }

    /* 队尾入队 */
    public void pushLast(Item num) {
        resize();

        size++;
        // 队尾入队先在队尾添加num
        nums[tail] = num;
        // 队尾指针再向队尾移动一位，越过尾部则返回队首
        tail = (tail + 1) % capacity();
    }

    /**
     * 扩容为原来的2倍大小
     */
    private void resize() {
        if (size == capacity()) {
            System.out.println("双向队列已满，开始扩容");
            Item[] newNums = (Item[]) new Object[capacity() << 1];
            // 需要重新赋值，打破之前的数组循环
            reInitialNums(newNums);
        }
    }

    /* 队首出队 */
    public Item pollFirst() {
        if (size == 0) {
            return null;
        }

        Item num = peekFirst();

        // 队首元素出队，队首指针需要向队尾移动一位，越过尾部返回队首
        head = (head + 1) % capacity();
        size--;

        contractSize();

        return num;
    }

    /* 队尾出队 */
    public Item pollLast() {
        if (size == 0) {
            return null;
        }

        Item num = peekLast();

        // 队尾元素出队，队尾指针需要向队首移动一位，越过队首返回队尾
        tail = (tail - 1 + capacity()) % capacity();
        size--;

        contractSize();

        return num;
    }

    /**
     * 缩容，如果容量只占用到容量的一半，那么缩小容量到原来的 75%
     */
    private void contractSize() {
        if (size == (capacity() >>> 1) && size > 4) {
            System.out.println("容量只占用到容量的一半，缩小容量到原来的 75%");
            Item[] newNums = (Item[]) new Object[size + (capacity() >>> 2)];
            // 赋值
            reInitialNums(newNums);
        }
    }

    /**
     * 重新赋值
     */
    private void reInitialNums(Item[] newNums) {
        for (int i = head, j = 0, k = size; k > 0; i = (++i % capacity()), j++, k--) {
            newNums[j] = nums[i];
        }
        this.nums = newNums;

        // 更正指针位置
        head = 0;
        tail = size;
    }

    /* 访问队首元素 */
    public Item peekFirst() {
        return isEmpty() ? null : nums[head];
    }

    /* 访问队尾元素 */
    public Item peekLast() {
        // 队尾指针所在的位置是队尾元素的后一位，取值时需要取队尾指针前一位，越过队首则返回队尾
        return isEmpty() ? null : nums[(tail - 1 + capacity()) % capacity()];
    }
}
