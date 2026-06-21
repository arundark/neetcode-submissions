class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int iland = 0;

        for (int sr = 0; sr < row; sr++) {
            for (int sc = 0; sc < col; sc++) {
                if (grid[sr][sc] == '1') {
                    dfs(grid, sr, sc, row, col);
                    iland++;
                }
            }
        }
        return iland;
    }

    public void dfs(char[][] grid, int sr, int sc, int row, int col) {
        if (Math.min(sr, sc) < 0 || sr >= row || sc >= col || grid[sr][sc] == '0') {
            return;
        }

        grid[sr][sc] = '0';

        dfs(grid, sr + 1, sc, row, col);
        dfs(grid, sr - 1, sc, row, col);
        dfs(grid, sr, sc + 1, row, col);
        dfs(grid, sr, sc - 1, row, col);
    }
}
