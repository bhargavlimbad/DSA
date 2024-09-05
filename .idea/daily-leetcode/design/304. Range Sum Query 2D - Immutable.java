/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 */
class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m][n+1];

        for (int i=0;i<m;i++) {
            int curr = 0;
            for (int j=1;j<n+1;j++) {
                curr += matrix[i][j-1];
                sum[i][j] = curr;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i=row1;i<=row2;i++) {
            result += (sum[i][col2+1]-sum[i][col1]);
        }
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
