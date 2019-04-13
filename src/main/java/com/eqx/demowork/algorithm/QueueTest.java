package com.eqx.demowork.algorithm;

/**
 * @ClassName QueueTest
 * @Description 队列测试
 * @Author duanhuazhen
 * @Date 15:39 2019-03-28
 * @Version 1.0
 **/
public class QueueTest {

    // 数组队列

    // 环形队列

    // 无锁并发队列
}

class CirQueue {
    int count;
    String[] queue;
    int head;
    int tail;

    public CirQueue(int capcity) {
        count = capcity;
        queue = new String[count];
        head = 0;
        tail = 0;
    }

    public boolean enqueue(String elem) {
        // 队列满了
        if ((tail + 1) % count == head) {
            return false;
        }
        queue[tail] = elem;
        tail = (tail + 1) % count;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String value = queue[head];
        head = (head + 1) % count;
        return value;
    }
}

class ArrayQueue {
    int count;
    String[] queue;
    int head;
    int tail;

    public ArrayQueue(int capcity) {
        count = capcity;
        queue = new String[count];
        head = 0;
        tail = 0;
    }

    public boolean enqueue(String elem) {
        // 队列满了
        if (count == tail) {
            return false;
        }
        queue[tail] = elem;
        tail++;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String value = queue[head];
        head++;
        return value;
    }
}