/**
 * https://leetcode.com/problems/design-circular-deque/description/
 */
class MyCircularDeque {
    class DLL {
        int val;
        DLL prev;
        DLL next;

        DLL (int val) {
            this.val = val;
            prev = next = null;
        }
    }

    DLL head;
    DLL tail;
    int capacity;
    int size;

    public MyCircularDeque(int k) {
        head = new DLL(-1);
        tail = new DLL(-1);

        head.next = tail;
        tail.prev = head;

        capacity = k;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        else {
            DLL dll = new DLL(value);
            DLL temp = head.next;

            dll.next = temp;
            dll.prev = head;

            temp.prev = dll;
            head.next = dll;

            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        else {
            DLL dll = new DLL(value);
            DLL temp = tail.prev;

            dll.next = tail;
            dll.prev = temp;

            tail.prev = dll;
            temp.next = dll;

            size++;
            return true;
        }
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        else {
            DLL temp = head.next;

            head.next = temp.next;
            temp.next.prev = head;

            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        else {
            DLL temp = tail.prev;

            tail.prev = temp.prev;
            temp.prev.next = tail;

            size--;
            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return head.next.val;
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return tail.prev.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */