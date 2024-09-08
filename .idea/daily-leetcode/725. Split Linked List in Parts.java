/**
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        for (int i=0;i<k;i++) {
            result[i] = new ListNode(-1);
        }
        ListNode curr = head;
        int len = lengthOfLL(curr);

        int attach = len/k;
        int extra = len%k;
        curr = head;

        for (int i=0;i<k;i++) {
            ListNode node = result[i];
            int tempAttach = attach;
            if (extra != 0) {
                tempAttach++;
                extra--;
            }

            while (tempAttach-- > 0) {
                ListNode temp  = curr;
                curr = curr.next;
                temp.next = null;

                node.next = temp;
                node = node.next;
            }
        }

        for (int i=0;i<k;i++) {
            result[i] = result[i].next;
        }

        return result;
    }
    public int lengthOfLL(ListNode root) {
        ListNode curr = root;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}