/**
 * https://leetcode.com/problems/map-sum-pairs/description/
 */
class MapSum {
    Map<String, Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int result = 0;
        for (String key : map.keySet()) {
            if (isKeyHasPrefix(prefix, key)) {
                result += map.get(key);
            }
        }

        return result;
    }

    private boolean isKeyHasPrefix(String prefix, String key) {
        int n = prefix.length();
        if (n > key.length()) return false;

        String key1 = key.substring(0, n);

        if (key1.equals(prefix)) return true;
        return false;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

