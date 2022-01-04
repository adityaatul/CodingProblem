class Node {
    Node prev;
    Node next;
    int key;
    int val;
    Node(int key, int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
        this.key = key;
    }
}
class LRUCache {
    Map<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.capacity = capacity;
        setHeadTail();
    }
    
    public int get(int key) {
        Node node = this.cache.getOrDefault(key, null);
        if (node == null ) {
            return -1;
        }
        detachNode(node);
        updateNodeToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {        
        Node node = this.cache.getOrDefault(key, null);
        if (node == null && capacity == this.cache.size()) {
            int keyToEvit = evitFromTail();
            this.cache.remove(keyToEvit);
        }
        if (node == null){
            node = new Node(key, value);
            this.cache.put(key, node);
        }else {
            node.val = value;
            detachNode(node);
        }
        updateNodeToHead(node);
    }
      
    void setHeadTail() {
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    int evitFromTail() {
        Node temp = tail.prev;
        Node tempPrev = temp.prev;
        tempPrev.next = tail;
        tail.prev = tempPrev;
        return temp.key;
    }
    
    void detachNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }
    
    void updateNodeToHead(Node node) {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 /*
        ["LRUCache","put","put","get","put","get","put","get","get","get"]
        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        {H}-> <-[1,1]-> -> <-[2,2]-> <- <-{T}
     */