package leetcode.sept2020;

public class MaxXorOf2NumberInArray {
    public static void main(String[] args) {
        //3,10,5,25,2,8
        System.out.println(new Solution15().findMaximumXOR(new int[]{3,10,5,25,2,8}));
    }
}

class Solution15 {
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        TrieNode root = new TrieNode();
        makeTrie(nums,root);
        for (int i = 0; i < nums.length; i++) {
            int val = searchTrie(root,nums[i]);
            ans = Math.max(ans,val);
        }
        return ans;
    }

    private int searchTrie(TrieNode root, int num) {
        TrieNode temp = root;
        int val=0;
        for (int i = 31; i >=0; i--) {
            if (((1<<i)&num)>0){
                if (temp.left!=null) {
                    val += (1<<i);
                    temp = temp.left;
                }else {
                    temp = temp.right;
                }
            }else {
                if (temp.right!=null) {
                    val += (1<<i);
                    temp = temp.right;
                }else {
                    temp = temp.left;
                }
            }
        }
        return val;
    }

    private void makeTrie(int[] nums, TrieNode root) {
        for (int i = 0; i < nums.length; i++) {
            insertTrie(root,nums[i]);
        }
    }

    private void insertTrie(TrieNode root, int num) {
        TrieNode temp=root;
        for (int i = 31; i >=0; i--) {
            if (((1<<i)&num)>0){
                if (temp.right==null){
                    temp.right = new TrieNode();
                }
                temp=temp.right;
            }else {
                if(temp.left==null){
                    temp.left = new TrieNode();
                }
                temp=temp.left;
            }
        }
    }
}