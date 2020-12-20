package AmazonMicrosoftQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOT {
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
class Solution8 {

    private static int endLevel = -9999999;
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList();
        List<Integer> temp = new ArrayList();
        q.offer(new TreeNode(endLevel));
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            temp.add(node.val);
            if(node.left != null){
                q.offer(node.left);
            }if(node.right != null){
                q.offer(node.right);
            }
            if(q.peek().val == endLevel){
                q.offer(q.remove());
                res.add(temp);
                temp = new ArrayList();
            }
        }
        return res;
    }
}
