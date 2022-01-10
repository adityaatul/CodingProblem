/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode head = buildTreeHelper(map, preorder, 0, preorder.length, new int[]{0});
        return head;
    }
    TreeNode buildTreeHelper(Map<Integer, Integer> map, int[] preorder, int start, int end, int[] idx) {
        if (start > end || idx[0] >= preorder.length) {
            return null;
        }
        int mid = map.get(preorder[idx[0]]);
        int val = preorder[idx[0]++];
        TreeNode temp = new TreeNode(val);
        temp.left = buildTreeHelper(map, preorder, start, mid - 1, idx);
        temp.right = buildTreeHelper(map, preorder, mid + 1, end, idx);
        return temp;
    }
    
}