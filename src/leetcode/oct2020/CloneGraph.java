package leetcode.oct2020;

import java.util.*;

public class CloneGraph {
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution20 {
    Map<Node,Node> orignalToClone;
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;

        orignalToClone = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        que.offer(node);

        while(!que.isEmpty()){
            Node currNode = que.poll();
            Node newNode = new Node(currNode.val);
            orignalToClone.put(currNode,newNode);
            List<Node> neighbors = currNode.neighbors;
            for (Node temp:neighbors) {
                if(!orignalToClone.containsKey(temp)){
                    que.offer(temp);
                }
            }
        }
        for (Map.Entry<Node,Node> entry: orignalToClone.entrySet()) {
            Node originalNode = entry.getKey();
            Node cloneNode = entry.getValue();
            List<Node> list = new ArrayList<>();
            for (Node temp:originalNode.neighbors) {
                list.add(orignalToClone.get(temp));
            }
            cloneNode.neighbors=list;
        }
        return orignalToClone.getOrDefault(node,null);
    }
}