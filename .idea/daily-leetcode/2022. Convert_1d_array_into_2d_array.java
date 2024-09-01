/**
 * https://leetcode.com/problems/convert-1d-array-into-2d-array/description/
 */
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = m*n;
        int cLen = original.length;
        int[][] result = new int[m][n];

        if (len != cLen) return new int[0][0];

        int row = 0, col = 0;
        int k = 0;
        while (k < cLen) {
            while (col < n) {
                result[row][col++] = original[k++];
            }
            row++;
            col = 0;
        }

        return result;
    }
}
/**
 *  cRow = i/col
 *  cCol = i%col
 */
