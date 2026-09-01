class TreeNode {
    boolean isWord;
    HashMap<Character, TreeNode> children;

    public TreeNode() {
        isWord = false;
        children = new HashMap<>();
    }

    public void addWord(String word) {
        TreeNode node = this;

        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i))) {
                node.children.put(word.charAt(i), new TreeNode());
            }

            node = node.children.get(word.charAt(i));
        }
        node.isWord = true;
    }
}

class Solution {
    int ROW;
    int COL;
    List<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        ROW = board.length;
        COL = board[0].length;
        TreeNode node = new TreeNode();
        int[][] visited = new int[ROW][COL];
        String word = "";
        result = new ArrayList<>();

        for (String wd : words) {
            node.addWord(wd);
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                dfs(i, j, node, board, visited, word);
            }
        }

        return result;
    }

    public void dfs(int row, int col, TreeNode node, char[][] board, int[][] visited, String word) {
        if (row < 0 || col < 0 || row >= ROW || col >= COL || visited[row][col] == 1
            || !node.children.containsKey(board[row][col])) {
            return;
        }

        word += board[row][col];
        node = node.children.get(board[row][col]);
        visited[row][col] = 1;

        if (node.isWord) {
            result.add(word);
            node.isWord = false;
        }

        dfs(row + 1, col, node, board, visited, word);
        dfs(row, col + 1, node, board, visited, word);
        dfs(row - 1, col, node, board, visited, word);
        dfs(row, col - 1, node, board, visited, word);

        visited[row][col] = 0;
    }
}
