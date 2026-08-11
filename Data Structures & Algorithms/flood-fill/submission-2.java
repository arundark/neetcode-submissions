public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orig = image[sr][sc];
        if (orig == color)
            return image;

        dfs(image, sr, sc, orig, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int orig, int color) {
        int m = image.length, n = image[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != orig)
            return;
        image[r][c] = color;
        dfs(image, r + 1, c, orig, color);
        dfs(image, r - 1, c, orig, color);
        dfs(image, r, c + 1, orig, color);
        dfs(image, r, c - 1, orig, color);
    }
}