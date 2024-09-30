/**
 * https://leetcode.com/problems/design-a-stack-with-increment-operation/description/
 */
class CustomStack {
    Deque<Integer> deque = new ArrayDeque<>();
    int size;
    public CustomStack(int maxSize) {
        size = maxSize;
    }

    public void push(int x) {
        if (deque.size() == size) return;
        deque.addFirst(x);
    }

    public int pop() {
        if (deque.isEmpty()) return -1;
        return deque.pollFirst();
    }

    public void increment(int k, int val) {
        Stack<Integer> stack = new Stack<>();
        while (k != 0 && !deque.isEmpty()) {
            stack.push(deque.pollLast()+val);
            k--;
        }

        while (!stack.isEmpty()) {
            deque.addLast(stack.pop());
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */