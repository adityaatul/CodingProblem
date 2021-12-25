/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
 [[3]
 [5, 1] 
 [6, 2, 0, 8]
 [7,4]]
 x = 2
 
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>(); // Child : Parent mapping
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == target) {
                break;
            }
            if (curr.left != null) {
                queue.add(curr.left);
                map.put(curr.left, curr);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                map.put(curr.right, curr);
            }
        }
        queue.clear();
        queue.add(target);
        visited.add(target);
        
        while (k-- > 0) {
            if (queue.isEmpty()) {
                return res;
            }
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();
                if (curr.left != null && visited.add(curr.left)) {
                    queue.add(curr.left);
                }
                if (curr.right != null && visited.add(curr.right)) {
                    queue.add(curr.right);
                }
                if (map.get(curr) != null && visited.add(map.get(curr))) {
                    queue.add(map.get(curr));
                }
            }
        }
        
        while(!queue.isEmpty()){
            res.add(queue.poll().val);
        }
        
        return res;
    }
}