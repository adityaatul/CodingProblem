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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightSideViewRec(root, ans, 0);
        return ans;
    }
    public void rightSideViewRec(TreeNode root, List ans, int level) {
        if(root == null) {
            return;
        }
        if (level == ans.size()) {
            ans.add(root.val);
        }
        if (root.right != null) {
            rightSideViewRec(root.right, ans, level + 1);    
        }
        if (root.left != null) {
            rightSideViewRec(root.left, ans, level + 1);    
        }
    }
}