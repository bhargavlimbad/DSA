/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
 */
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();

        String[] split1 = s1.split(" ");
        for (String str : split1) {
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        String[] split2 = s2.split(" ");
        for (String str : split2) {
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        List<String> list = new ArrayList<>();
        for (String str : map.keySet()) {
            if (map.get(str) == 1) list.add(str);
        }

        //String[] result = new String[list.size()];
        //list.toArray(result);
        return list.stream().toArray(String[]::new);
    }
}