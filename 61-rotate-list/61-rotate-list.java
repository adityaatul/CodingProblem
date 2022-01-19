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
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0, tempVal;
        ListNode temp = head, newHead = null, prev = null;
        while (temp != null) {
            prev = temp;
            temp = temp.next;
            len += 1;
        }
        
        if (len < 2) {
            return head;
        }
        
        k = k % len;
        int rotate = len - k - 1;
        temp = head;
        
        while (rotate-- > 0) {
            temp = temp.next;
        }
        
        newHead = temp;
        prev.next = head;
        head = newHead.next;
        newHead.next = null;
        
        return head;
    }
}