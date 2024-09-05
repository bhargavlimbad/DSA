/**
 * https://leetcode.com/problems/find-missing-observations/description/
 */
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        int m = rolls.length;
        for (int i=0;i<m;i++) {
            sum += rolls[i];
        }

        int value = (mean*(n+m)) - sum;

        if (value < n || value > 6*n) return new int[0];

        int[] result = new int[n];
        int avg = value/n;
        for (int i=0;i<n;i++) {
            result[i] = avg;
        }
        value -= (avg*n);

        int index = 0;
        while (value != 0) {
            if (value + result[index] > 6) {
                value -= (6-result[index]);
                result[index] = 6;
                index++;
            } else {
                result[index] += value;
                value = 0;
            }
        }

        return result;
    }
}