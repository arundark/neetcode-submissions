class TreeNode {
    boolean isWord;
    HashMap<Character, TreeNode> children;

    public TreeNode() {
        isWord = false;
        children = new HashMap<>();
    }
}

class WordDictionary {
    TreeNode root;

    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode curr = root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TreeNode());
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(0, root, word);
    }

    public boolean dfs(int index, TreeNode root, String word) {
        TreeNode curr = root;

        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TreeNode child : curr.children.values()) {
                    if (dfs(i + 1, child, word)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!curr.children.containsKey(c)) {
                    return false;
                }

                curr = curr.children.get(c);
            }
        }
        return curr.isWord;
    }
}
