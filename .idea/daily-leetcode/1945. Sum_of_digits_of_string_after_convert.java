/**
 * https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/
 */
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(c-'a'+1);
        }

        String str = sb.toString();
        while (k-- > 0) {
            // System.out.println(str);
            str = transform(str);
        }

        return Integer.parseInt(str);
    }
    public String transform(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            sum += (c-'0');
        }

        return Integer.toString(sum);
    }
}