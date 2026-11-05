class TrieNode {
    boolean isWord;
    HashMap<Character, TrieNode> children;

    public TrieNode() {
        isWord = false;
        children = new HashMap();
    }

    public void addWord(String word) {
        TrieNode currentNode = this;
        for (char c : word.toCharArray()) {
            if (!currentNode.children.containsKey(c)) {
                currentNode.children.put(c, new TrieNode());
            }

            currentNode = currentNode.children.get(c);
        }

        currentNode.isWord = true;
    }
}

class Solution {
    Set<String> set;
    int[][] visit;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }

        int ROW = board.length;
        int COL = board[0].length;
        set = new HashSet<>();
        visit = new int[ROW][COL];
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                dfs(r, c, root, board, "");
            }
        }

        return new ArrayList<String>(set);
    }

    private void dfs(int r, int c, TrieNode node, char[][] board, String word) {
        int ROW = board.length;
        int COL = board[0].length;

        if (r < 0 || r >= ROW || c < 0 || c >= COL || visit[r][c] == 1
            || !node.children.containsKey(board[r][c])) {
            return;
        }

        visit[r][c] = 1;
        word += board[r][c];
        node = node.children.get(board[r][c]);
        if (node.isWord) {
            set.add(word);
        }

        dfs(r + 1, c, node, board, word);
        dfs(r - 1, c, node, board, word);
        dfs(r, c + 1, node, board, word);
        dfs(r, c - 1, node, board, word);

        visit[r][c] = 0;
    }
}
