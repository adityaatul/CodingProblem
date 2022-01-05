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
//         O(Nlogk) solution with O(k) space.
//          ListNode ans = null, head = null;
//         //Comparator on ListNode to make PQ on node value
//         PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));
        
//         for (ListNode l : lists) {
//             if (l != null) {
//                 queue.add(l);    
//             }
//         }
        
//         while (!queue.isEmpty()) {
//             ListNode temp = queue.poll();
//             if (ans == null) {
//                 ans = temp;
//                 head = ans;
//             } else {
//                 ans.next = temp;
//                 ans = ans.next;
//             }
//             if (temp.next != null) {
//                 queue.add(temp.next);    
//             }
//         }
//         return head;
        // if (lists == null || lists.length == 1 && lists[0] == null) {
        //     return null;
        // }
        ListNode head = null, temp = null;
        int size = lists.length;
        int seen = 0;
        
        while (size != seen) {
            int min = 100009, pos = -1;
            for (int i = 0; i < size; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    pos = i;
                }
            }
            if (pos == -1) {
                break;
            }
            if (temp == null) {
                temp = lists[pos];
                head = temp;
            } else {
                temp.next = lists[pos];
                temp = temp.next; 
            }
            lists[pos] = lists[pos].next;
            if (lists[pos] == null) {
                ++seen;
            }
        }
        return head;
    }
}