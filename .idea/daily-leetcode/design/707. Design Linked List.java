/**
 * https://leetcode.com/problems/design-linked-list/description/
 */
class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    Node head;
    int size;

    public MyLinkedList() {
        head = new Node(-1);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1; // Invalid index
        }
        Node curr = head.next;
        while (index-- > 0) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head.next;
        head.next = n;
        size++;
    }

    public void addAtTail(int val) {
        Node curr = head.next;

        if (curr == null) {
            addAtHead(val);
            return;
        }
        while (curr.next != null) {
            curr = curr.next;
        }

        Node n = new Node(val);
        curr.next = n;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return; // Invalid index
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node curr = head;
        while (index-- > 0) {
            curr = curr.next;
        }
        Node n = new Node(val);
        n.next = curr.next;
        curr.next = n;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return; // Invalid index
        }
        Node curr = head;
        while (index-- > 0) {
            curr = curr.next;
        }

        if (curr.next == null) {
            curr.next = null;
        } else {
            curr.next = curr.next.next;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

/**
 * Use DLL for optimized approach
 */