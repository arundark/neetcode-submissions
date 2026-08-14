class Solution {
    int[][] cache;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        cache = new int[row][col];

        return dfs(row, col, 0, 0, obstacleGrid);
    }

    public int dfs(int row, int col, int r, int c, int[][] obstacleGrid) {
        if (r == row || c == col || obstacleGrid[r][c] == 1) {
            return 0;
        }
        if (cache[r][c] != 0) {
            return cache[r][c];
        }
        if (r == row - 1 && c == col - 1) {
            return 1;
        }

        cache[r][c] = dfs(row, col, r + 1, c, obstacleGrid) + dfs(row, col, r, c + 1, obstacleGrid);

        return cache[r][c];
    }
}