/**
 * https://leetcode.com/problems/lexicographical-numbers/description/
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=n;i++) {
            list.add(i);
        }

        Collections.sort(list, (a, b) -> {
            String as = Integer.toString(a);
            String bs = Integer.toString(b);
            int i=0, j=0;
            while (i < as.length() && j <bs.length()) {
                char ac = as.charAt(i);
                char bc = bs.charAt(j);
                if (ac == bc) {
                    i++; j++;
                } else {
                    return ac - bc;
                }
            }
            return 0;
        });

        return list;
    }
}

/**
 * Approach 2 : O(N)
 */
