/**
 * https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description/
 */
class Solution {
    public int longestSubarray(int[] nums) {
        int maxEle = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i=0;i<n;i++) {
            maxEle = Math.max(maxEle, nums[i]);
        }

        int count = 0;
        int i = 0;
        while (i < n) {
            if (nums[i] == maxEle) {
                int len = 1, j = i + 1;
                while (j < n && nums[j] == nums[i]) {
                    len++; j++;
                }
                count = Math.max(count, len);
                i = j+1;
            } else {
                i++;
            }
        }

        return count;
    }
}
