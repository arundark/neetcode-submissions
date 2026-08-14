class Solution {
    int[][] cache;
    public int uniquePaths(int m, int n) {
        cache = new int[m][n];
        return dfs(m, n, 0, 0);
    }
    // Brute Force
    public int dfs(int m, int n, int r, int c) {
        if (r == m || c == n) {
            return 0;
        }
        if (cache[r][c] != 0) {
            return cache[r][c];
        }

        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        cache[r][c] = dfs(m, n, r + 1, c) + dfs(m, n, r, c + 1);
        return cache[r][c];
    }
}
