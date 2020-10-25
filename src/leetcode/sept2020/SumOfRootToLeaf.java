package leetcode.sept2020;



// Definition for a binary tree node.
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



public class SumOfRootToLeaf {
    public static void main(String[] args) {

    }
}
class Solution9 {
    int ans=0;
    public int sumRootToLeaf(TreeNode root) {
        Traverse(root,root.val);
        return ans;
    }
    void Traverse(TreeNode root,int value){
        if(root.left==null && root.right==null){
            ans+=(value<<1)+root.val;
            return;
        }
        if(root.left!=null)
        Traverse(root.left,(value<<1+root.left.val));
        if(root.right!=null)
        Traverse(root.right,(value<<1+root.right.val));
    }
}
