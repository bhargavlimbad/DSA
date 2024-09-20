/**
 * https://leetcode.com/problems/time-based-key-value-store/description/
 */
class TimeMap {
    class Node {
        int timestamp;
        String value;
        Node(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Node> list = null;
        if (map.containsKey(key)) {
            list = map.get(key);
        } else {
            list = new ArrayList<>();
        }

        list.add(new Node(timestamp, value));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Node> list = map.get(key);

        int start = 0, end = list.size()-1;
        String result = "";

        while (start <= end) {
            int mid = start + (end-start)/2;
            Node n = list.get(mid);
            if (n.timestamp > timestamp) end = mid-1;
            else {
                result = n.value;
                start = mid+1;
            }
        }

        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
