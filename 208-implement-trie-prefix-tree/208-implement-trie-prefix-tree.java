class Trie {
    class Node {
        char c;
        boolean endOfWord;
        Map<Character, Node> child;
        Node(char c, boolean endOfWord){
            this.c = c;
            this.endOfWord = endOfWord;
            this.child = new HashMap<>();
        }
    }

    Node trieNode;
    public Trie() {
        trieNode = new Node('*', false);
    }
    
    public void insert(String word) {
        Node temp = this.trieNode;
        for(char c: word.toCharArray()) {
            if (!temp.child.containsKey(c)) {
                Node newNode = new Node(c, false);
                temp.child.put(c, newNode);
            }
            temp = temp.child.get(c);
        }
        temp.endOfWord = true;
    }
    
    public boolean search(String word) {
        Node temp = this.trieNode;
        for(char c: word.toCharArray()) {
            if (!temp.child.containsKey(c)) {
                return false;
            }
            temp = temp.child.get(c);
        }
        return temp.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = this.trieNode;
        for(char c: prefix.toCharArray()) {
            if (!temp.child.containsKey(c)) {
                return false;
            }
            temp = temp.child.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */