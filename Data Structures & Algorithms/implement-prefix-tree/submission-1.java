class Node{
    boolean isWord;
    HashMap<Character,Node> children = new HashMap<>();
}

class PrefixTree {
    Node node;
    public PrefixTree() {
       node = new Node();  
    }

    public void insert(String word) {
        Node current = node;

        for(char c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.put(c, new Node());
            }

            current = current.children.get(c);
        }

        current.isWord = true;

    }

    public boolean search(String word) {
        Node current = node;

        for(char c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            }

            current = current.children.get(c);
        }

        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        Node current = node;

        for(char c : prefix.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            }

            current = current.children.get(c);
        }

        return true;
    }
}
