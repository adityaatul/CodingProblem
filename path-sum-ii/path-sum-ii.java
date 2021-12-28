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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        allPath(root, targetSum, res, temp);
        return res;
    }
    void allPath(TreeNode root, int target, List<List<Integer>> res, List<Integer> temp) {
        if (root == null){
            return ;
        }
        if (root.left == null && root.right == null && target - root.val == 0) {
            temp.add(root.val);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return ;
        }
        temp.add(root.val);
        allPath(root.left, target - root.val, res, temp);
        allPath(root.right, target - root.val, res, temp);
        temp.remove(temp.size() - 1);
    }
}