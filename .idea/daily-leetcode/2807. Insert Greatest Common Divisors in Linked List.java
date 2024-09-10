/**
 * https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/
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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            int x = curr.val;
            int y = curr.next.val;

            int data = gcd(x, y);

            ListNode n = new ListNode(data);
            n.next = curr.next;
            curr.next = n;

            curr = curr.next.next;
        }

        return head;
    }

    private int gcd(int x, int y) {
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }

        if (x == 0) return y;
        return gcd(y%x, x);
    }
}