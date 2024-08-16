/**
     https://leetcode.com/problems/lemonade-change/description/
     Greedy problem
     TC : O(N)
     SC : O(1)
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five >= 1) {
                    five--;
                    ten++;
                } else return false;
            } else if (bill == 20) {
                if (five >= 1 && ten >= 1) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else return false;
            }
        }

        return true;
    }
}