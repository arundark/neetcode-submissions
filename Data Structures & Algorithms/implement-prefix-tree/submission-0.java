class TreeNode {
    boolean isWord;
    HashMap<Character, TreeNode> map = new HashMap<>();
}

class PrefixTree {
    TreeNode root;
    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.map.containsKey(c)) {
                curr.map.put(c, new TreeNode());
            }
            curr = curr.map.get(c);
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        TreeNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root;

        for (char c : prefix.toCharArray()) {
            if (!curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }
        return true;
    }
}
