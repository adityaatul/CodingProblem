/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serializeString = new StringBuilder ();
        bfs(root, serializeString);
        System.out.println(serializeString.toString());
        return serializeString.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String input) {
        TreeNode head = null;
        if (input.charAt(0) == 'N') return head;
        Queue<TreeNode> queue = new LinkedList<>(); 
        String[] data = input.split("#");
        
        int size = data.length;
        int val = Integer.valueOf(data[0]);
        head = new TreeNode(val);
        int used = 1;
        queue.add(head);
        int k = 1;
        
        while (k < size) {
            int qs = queue.size();
            while (qs-- > 0 && k < size) {
                TreeNode temp = queue.poll();
                if (k < size && !data[k].equals("N")){
                    val = Integer.valueOf(data[k]);    
                    TreeNode left = new TreeNode(val);
                    temp.left = left;
                    queue.add(left);
                }
                ++k;
                if (k < size && !data[k].equals("N")){
                    val = Integer.valueOf(data[k]);    
                    TreeNode right = new TreeNode(val);
                    temp.right = right;
                    queue.add(right);
                }
                ++k;
            }
          
        }   
        return head;
    }
    
    void bfs(TreeNode node, StringBuilder s) {
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                s.append("N");
                s.append("#");
                continue;
            } else {
                s.append(temp.val);
                s.append("#");
            }
            TreeNode left = temp.left;
            TreeNode right = temp.right;
            queue.add(left);
            queue.add(right);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;

/*
     2
    1 3 
    
    [5,3,7,n,4,n,10]
    
    3 7
    [5,3,7,null,4,null,10]
    
    213NNNN
*/