/**
 * https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
 */
class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;

        if (start == goal) return count;
        while (start != 0 || goal != 0) {
            int sb = start%2;
            int gb = goal%2;
            if (sb+gb == 1) count++;
            start /= 2;
            goal /= 2;
        }

        return count;
    }
}