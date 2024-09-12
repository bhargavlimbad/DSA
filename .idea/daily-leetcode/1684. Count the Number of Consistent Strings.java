/**
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/description/
 */
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : allowed.toCharArray()) {
            map.put(c, 1);
        }

        int result = 0;
        for (String s : words) {
            if (isConsistent(s, map)) {
                System.out.println(s);
                result++;
            }
        }

        return result;
    }
    public boolean isConsistent(String s, Map<Character, Integer> map) {
        int count = map.size(), curr = 0;

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) return false;
        }

        return true;
    }
}

/**
 * Bit manipulation approach
 */
