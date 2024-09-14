/**
 * https://leetcode.com/problems/design-circular-queue/description/
 */
class MyCircularQueue {
    int[] queue;
    int front, rear, size;
    int capacity;

    public MyCircularQueue(int k) {
        queue = new int[k];
        front = rear = -1;
        size = 0;
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (size == capacity) return false;

        if (rear == -1) {
            front = 0;
            rear = 0;
            queue[0] = value;
            size++;
            return true;
        }

        rear = (rear+1)%capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (front == -1) return false;
        front = (front+1)%capacity;
        size--;

        if (size == 0) {
            front = rear = -1;
        }

        return true;
    }

    public int Front() {
        if (front == -1) return -1;
        return queue[front];
    }

    public int Rear() {
        if (rear == -1) return -1;
        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
