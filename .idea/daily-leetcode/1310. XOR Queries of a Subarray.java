/**
 * https://leetcode.com/problems/xor-queries-of-a-subarray/description/
 */
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length, index = 0;
        int[] result = new int[n];

        for (int[] que : queries) {
            int ans = 0;
            for (int i=que[0];i<=que[1];i++) {
                ans = ans^arr[i];
            }
            result[index++] = ans;
        }

        return result;
    }
}
/**
 * Approach 2 (pre computation)
 */