class TreeNode {
    boolean isWord;
    TreeNode[] children;

    public TreeNode() {
        isWord = false;
        children = new TreeNode[26];
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
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TreeNode();
            }
            curr = curr.children[c - 'a'];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int j, TreeNode root) {
        TreeNode curr = root;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TreeNode child : curr.children)
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                return false;
            } else {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
        }
        return curr.isWord;
    }
}
