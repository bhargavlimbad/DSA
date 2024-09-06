/**
 * https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int ele : nums) {
            set.add(ele);
        }

        if (head == null) return head;

        ListNode node = head;
        while (node.next != null) {
            if (set.contains(node.next.val)) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        if (set.contains(head.val)) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }
        return head;
    }
}