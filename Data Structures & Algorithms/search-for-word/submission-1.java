class Solution {
    int ROW;
    int COL;

    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;
        int index = 0;
        int[][] visit = new int[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == word.charAt(index)) {
                    if (dfs(i, j, index, board, word, visit)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(int row, int col, int index, char[][] board, String word, int[][] visit) {
        char c = word.charAt(index);

        if (row < 0 || col < 0 || row >= ROW || col >= COL || visit[row][col] == 1
            || board[row][col] != c) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        visit[row][col] = 1;

        if (dfs(row + 1, col, index + 1, board, word, visit)) {
            return true;
        }
        if (dfs(row, col + 1, index + 1, board, word, visit)) {
            return true;
        }
        if (dfs(row - 1, col, index + 1, board, word, visit)) {
            return true;
        }

        if (dfs(row, col - 1, index + 1, board, word, visit)) {
            return true;
        }
        visit[row][col] = 0;
        return false;
    }
}
