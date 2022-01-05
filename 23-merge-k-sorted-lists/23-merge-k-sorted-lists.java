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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null, head = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));
        
        for (ListNode l : lists) {
            if (l != null) {
                queue.add(l);    
            }
        }
        
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            if (ans == null) {
                ans = temp;
                head = ans;
            } else {
                ans.next = temp;
                ans = ans.next;
            }
            if (temp.next != null) {
                queue.add(temp.next);    
            }
        }
        return head;
    }
}