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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head, prev = null; 
        ListNode next = head.next;
        
        while (temp != null) {
            temp.next = prev;
            prev = temp;
            temp = next;
            if (next != null) next = next.next;        
        }
        return prev;
    }
}

/*
P =null

T    N
1 -> 2 -> 3

1  2 -> 3
      T  N
1  <- 2  3

T.next = P ;
P = T
T = next;
next = next.next


*/