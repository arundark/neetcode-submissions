class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orginal = image[sr][sc];
        return floodFill(image, sr, sc, color, orginal);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color, int orginal) {
        int rows = image.length;
        int columns = image[0].length;
        if (Math.min(sr, sc) < 0 || sr == rows || sc == columns || image[sr][sc] != orginal || image[sr][sc] == color) {
            return image;
        }

        image[sr][sc] = color;
        floodFill(image, sr + 1, sc, color, orginal);
        floodFill(image, sr - 1, sc, color, orginal);
        floodFill(image, sr, sc + 1, color, orginal);
        floodFill(image, sr, sc - 1, color, orginal);

        return image;
    }
}