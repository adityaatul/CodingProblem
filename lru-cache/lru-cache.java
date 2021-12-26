class Node{
    int value;
    int key;
    Node next;
    Node prev;
    Node(int v,int k){
        value = v;
        key = k;
        next = null;
        prev = null;
    }
}
class LRUCache {
    Map<Integer, Node> LRUCacheMap;
    int capacity;
    int count;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        LRUCacheMap = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
        head = new Node(0,0);
        tail = new Node(0,0);
        intializeNode(head,tail);
    }

    private void intializeNode(Node head, Node tail) {
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }
    /*
        ["LRUCache","put","put","get","put","get","put","get","get","get"]
        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        {H}-> <-[1,1]-> -> <-[2,2]-> <- <-{T}
     */
    public int get(int key) {
        Node res = LRUCacheMap.getOrDefault(key, null);
        if(res != null){
            int val = res.value;
            delNode(res);
            setNode(res);
            return val;
        }
        return -1;
    }

    private void setNode(Node res) {
        res.prev = tail.prev;
        tail.prev.next = res;
        res.next = tail;
        tail.prev = res;
    }

    private void delNode(Node res) {
        res.next.prev = res.prev;
        res.prev.next = res.next;
    }

    public void put(int key, int value) {
        if(LRUCacheMap.get(key) != null){
            Node node = LRUCacheMap.get(key);
            node.value = value;
            delNode(node);
            setNode(node);
        }else{
            Node node = new Node(value, key);
            LRUCacheMap.put(key, node);
            if(count < capacity){
                ++count;
                setNode(node);
            }else{
                Node dNode = head.next;
                LRUCacheMap.remove(dNode.key);
                delNode(dNode);
                setNode(node);
            }
        }
    }

}