package cn.msjava.coding;

/**
 * @author msJava
 * @Description: 622. 设计循环队列
 */
public class MyCircularQueue {

    // 已经使用的元素个数
    private int used = 0;

    // 第一个元素所在位置
    private int front = 0;

    // rear是enQueue可在存放的位置
    // 注意开闭原则
    // [front, rear)
    private int rear = 0;

    // 循环队列最多可以存放的元素个数
    private int capacity = 0;

    // 循环队列的存储空间
    private int[] a = null;

    public MyCircularQueue(int k) {
        // 初始化循环队列
        capacity = k;
        a = new int[capacity];
    }


    /**
     * index = i 的后一个 (i + 1) % capacity
     *
     * index = i 的前一个(i - 1 + capacity) % capacity
     */
    /**
     * 向循环队列插入一个元素。如果成功插入则返回真
     *
     *
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        // 如果已经放满了
        if (isFull()) {
            return false;
        }
        // 如果没有放满，那么a[rear]用来存放新进来的元素
        a[rear] = value;
        // rear注意取模
        rear = (rear + 1) % capacity;
        // 已经使用的空间
        used++;
        // 存放成功!
        return true;
    }

    /**
     * 从循环队列中删除一个元素。如果成功删除则返回真
     * @return
     */
    public boolean deQueue() {
        // 如果是一个空队列，当然不能出队
        if (isEmpty()) {
            return false;
        }
        // 第一个元素取出
        int ret = a[front];
        // 注意取模
        front = (front + 1) % capacity;
        // 已经存放的元素减减
        used--;
        // 取出元素成功
        return true;
    }

    /**
     * 从队首获取元素。如果队列为空，返回 -1
     * @return
     */
    public int Front() {
        // 如果为空，不能取出队首元素
        if (isEmpty()) {
            return -1;
        }
        // 取出队首元素
        return a[front];
    }

    /**
     * 获取队尾元素。如果队列为空，返回 -1
     * @return
     */
    public int Rear() {
        // 如果为空，不能取出队尾元素
        if (isEmpty()) {
            return -1;
        }
        // 注意：这里不能使用rear - 1
        // 需要取模
        int tail = (rear - 1 + capacity) % capacity;
        return a[tail];
    }

    // 队列是否为空
    public boolean isEmpty() {
        return used == 0;
    }

    // 队列是否满了
    public boolean isFull() {
        return used == capacity;
    }

}
