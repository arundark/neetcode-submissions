class Node {
    boolean isWord;
    HashMap<Character, Node> children = new HashMap<>();
}
class WordDictionary {
    Node node;
    public WordDictionary() {
        node = new Node();
    }

    public void addWord(String word) {
        Node current = node;

        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new Node());
            }
            current = current.children.get(c);
        }

        current.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, node);
    }

    private boolean dfs(String word, int j, Node children) {
        Node current = children;
        for (int i = j; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (Node child : current.children.values()) {
                    if (!current.children.isEmpty() && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!current.children.containsKey(word.charAt(i))) {
                    return false;
                }
                current = current.children.get(word.charAt(i));
            }
        }

        return current.isWord;
    }
}
