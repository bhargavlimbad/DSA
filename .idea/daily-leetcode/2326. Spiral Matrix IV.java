/**
 * https://leetcode.com/problems/spiral-matrix-iv/description/
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        ListNode curr = head;
        int top = 0, bottom = m-1, left = 0, right = n-1;

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                result[i][j] = -1;
            }
        }

        while (curr != null && left <= right && top <= bottom) {
            // top row
            if (curr != null && left <= right && top <= bottom) {
                for (int i=left;i<=right;i++) {
                    result[top][i] = curr.val;
                    curr = curr.next;
                    if (curr == null) break;
                }
                top++;
            }

            // right column
            if (curr != null && left <= right && top <= bottom) {
                for (int i=top;i<=bottom;i++) {
                    result[i][right] = curr.val;
                    curr = curr.next;
                    if (curr == null) break;
                }
                right--;
            }

            // bottom row
            if (curr != null && left <= right && top <= bottom) {
                for (int i=right;i>=left;i--) {
                    result[bottom][i] = curr.val;
                    curr = curr.next;
                    if (curr == null) break;
                }
                bottom--;
            }

            // left column
            if (curr != null && left <= right && top <= bottom) {
                for (int i=bottom;i>=top;i--) {
                    result[i][left] = curr.val;
                    curr = curr.next;
                    if (curr == null) break;
                }
                left++;
            }
        }

        return result;
    }
}