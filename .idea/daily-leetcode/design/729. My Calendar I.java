/**
 * https://leetcode.com/problems/my-calendar-i/description/
 */
class MyCalendar {
    Map<Integer, Integer> slot;

    public MyCalendar() {
        slot = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        slot.put(start, slot.getOrDefault(start, 0) + 1);
        slot.put(end, slot.getOrDefault(end, 0) - 1);

        int counter = 0;
        for (int key : slot.keySet()) {
            counter += slot.get(key);
            if (counter > 1) {
                slot.put(start, slot.get(start)-1);
                if (slot.get(start) == 0) slot.remove(start);

                slot.put(end, slot.get(end)+1);
                if (slot.get(end) == 0) slot.remove(end);

                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
