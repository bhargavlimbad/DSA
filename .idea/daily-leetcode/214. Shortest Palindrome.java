/**
 * https://leetcode.com/problems/shortest-palindrome/
 */
class Solution {
    public String shortestPalindrome(String s) {
        if (isPalindrome(s)) return s;

        String curr = "";
        int n = s.length();
        int index = n-1;

        while (index >= 0) {
            curr += s.charAt(index--);
            if (isPalindrome(curr+s)) return curr+s;
        }

        return curr+s;
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i=0;i<n/2;i++) {
            if (s.charAt(i) != s.charAt(n-1-i)) return false;
        }
        return true;
    }
}

/**
 * Approach 2
 */