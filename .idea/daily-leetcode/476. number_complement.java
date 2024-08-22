/**
 * https://leetcode.com/problems/number-complement/description/
 */
class Solution {
    public int findComplement(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (num%2 != 0) sb.append('1');
            else sb.append('0');

            num = num/2;
        }

        int result = 0, fact = 1;
        for (int i=0;i<sb.length();i++) {
            if (sb.charAt(i) == '0') {
                result += fact;
            }
            fact *= 2;
        }

        return result;
    }
}
