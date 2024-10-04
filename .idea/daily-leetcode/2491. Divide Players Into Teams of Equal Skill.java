/**
 * https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/
 */
class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        if (n == 2) {
            return (long) skill[0]*skill[1];
        }

        Arrays.sort(skill);

        int base  = skill[0]+skill[n-1];
        long result = skill[0]*skill[n-1];
        int i = 1, j = n-2;

        while (i < j) {
            if (skill[i]+skill[j] != base) return -1;

            result += (long) (skill[i]*skill[j]);
            i++; j--;
        }

        return result;
    }
}