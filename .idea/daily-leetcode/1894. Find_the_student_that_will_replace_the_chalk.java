/**
 * https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/description/
 */
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int ele : chalk) {
            sum += ele;
        }

        k = (int) (k%sum);

        for (int i=0;i<chalk.length;i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }

        return -1;
    }
}