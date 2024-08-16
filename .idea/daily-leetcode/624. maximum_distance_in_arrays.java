/**
 * https://leetcode.com/problems/maximum-distance-in-arrays/description/
 *
 * Approach 1:
 * 1. Create minArr of size m which will be first element from all arrays
 * 2. Create maxArr of size m which will be last element from all arrays
 * 3. Check for every element in minArr that which maxArr element can give max difference,
 *    here do not consider i == j pair as element should be from district array to make pair.
 * TC : O(m^2)
 * SC : O(m)
 */

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        int[] minArr = new int[m];
        int[] maxArr = new int[m];

        for (int i=0;i<m;i++) {
            List<Integer> list = arrays.get(i);
            minArr[i] = list.get(0);
            maxArr[i] = list.get(list.size()-1);
        }

        int result = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<m;j++) {
                if (i != j) {
                    result = Math.max(result, Math.abs(minArr[i]-maxArr[j]));
                }
            }
        }

        return result;
    }
}

/**
 * Approach 2 :
 * TODO Write clean code
 *
 * TC : O(m)
 * SC : O(1)
 */
class Solution {
    class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        // Pair<Value, Index>
        Pair pMax1 = new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Pair pMax2 = new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Pair pMin1 = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Pair pMin2 = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (int i=0;i<m;i++) {
            List<Integer> list = arrays.get(i);

            int currMin = list.get(0);
            if (currMin <= pMin1.first) {
                pMin2.first = pMin1.first;
                pMin2.second = pMin1.second;

                pMin1.first = currMin;
                pMin1.second = i;
            } else if (currMin > pMin1.first && currMin <= pMin2.first) {
                pMin2.first = currMin;
                pMin2.second = i;
            }

            int currMax = list.get(list.size()-1);
            if (currMax >= pMax1.first) {
                pMax2.first = pMax1.first;
                pMax2.second = pMax1.second;

                pMax1.first = currMax;
                pMax1.second = i;
            } else if (currMax < pMax1.first && currMax >= pMax2.first) {
                pMax2.first = currMax;
                pMax2.second = i;
            }
        }

        System.out.println(pMax1.first + " " + pMax1.second + " | " + pMax2.first + " " + pMax2.second);
        System.out.println(pMin1.first + " " + pMin1.second + " | " + pMin2.first + " " + pMin2.second);

        if (pMax1.second != pMin1.second) {
            return (pMax1.first-pMin1.first);
        } else {
            return Math.max((pMax1.first-pMin2.first),
                    (pMax2.first-pMin1.first));
        }
    }
}
