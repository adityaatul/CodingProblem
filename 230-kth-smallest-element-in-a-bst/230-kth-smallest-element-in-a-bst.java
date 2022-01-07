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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        kthSmallestHelper(root, arr);
        return arr.get(k-1);
    }
    
    void kthSmallestHelper(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return ;
        }
        kthSmallestHelper(root.left, arr);
        arr.add(root.val);
        kthSmallestHelper(root.right, arr);
    }
    
}