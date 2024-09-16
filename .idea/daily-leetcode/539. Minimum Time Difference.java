/**
 * https://leetcode.com/problems/minimum-time-difference/description/
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> time = new ArrayList<>();
        for (String timeEle : timePoints) {
            time.add(convertIntoMinutes(timeEle));
        }

        Collections.sort(time);

        int ans = Integer.MAX_VALUE;
        int n = time.size();
        for (int i=1;i<=n;i++) {
            int x = time.get(i-1);
            int y = time.get(i%n);
            if (x == y) return 0;

            int r1 = Math.abs(x-y);
            r1 = Math.min(r1, 1440-r1);
            ans = Math.min(ans, r1);
        }

        return ans;
    }

    public int convertIntoMinutes(String s) {
        int result = 0;
        int h1 = s.charAt(0) - '0';
        int h2 = s.charAt(1) - '0';
        int m1 = s.charAt(3) - '0';
        int m2 = s.charAt(4) - '0';

        return ((h1*10+h2)*60) + (m1*10+m2);
    }
}
