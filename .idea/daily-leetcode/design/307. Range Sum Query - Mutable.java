/**
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 */
class NumArray {
    int[] data;
    int[] arr;
    int len;
    public NumArray(int[] nums) {
        len = nums.length;
        arr = nums;
        data = new int[len+1];

        preCompute(1, len);
    }

    private void preCompute(int start, int end) {
        for (int i=start;i<=end;i++) {
            data[i] = data[i-1] + arr[i-1];
        }
    }

    public void update(int index, int val) {
        arr[index] = val;
        preCompute(index+1 ,len);
    }

    public int sumRange(int left, int right) {
        return (data[right+1]-data[left]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

/**
 * Approach 2 :
 */