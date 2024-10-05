/**
 * https://leetcode.com/problems/permutation-in-string/description/
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c1 : s1.toCharArray()) {
            map.put(c1, map.getOrDefault(c1,0)+1);
        }
        int count = map.size(), k = s1.length(), n = s2.length();

        int i=0,j=0;
        while (j < n) {
            char c2 = s2.charAt(j);
            if (map.containsKey(c2)) {
                map.put(c2, map.get(c2)-1);

                if (map.get(c2) == 0) count--;
            }

            if ((j-i+1) < k) j++;
            else if ((j-i+1) == k) {
                if (count ==0) return true;

                char c3 = s2.charAt(i);
                if (map.containsKey(c3)) {
                    map.put(c3, map.get(c3)+1);
                    if (map.get(c3) == 1) count++;
                }
                i++; j++;
            }
        }

        return false;
    }
}