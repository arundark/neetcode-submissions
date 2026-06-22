class Solution {
    public int orangesRotting(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] visit = new int[ROW][COL];
        int[] freshCount = {0};
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshCount[0] += 1;
                }
            }
        }

        int time = 0;

        while (freshCount[0] > 0 && !queue.isEmpty()) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                int[] rc = queue.pop();
                int r = rc[0];
                int c = rc[1];

                bfs(grid, r + 1, c, ROW, COL, queue, freshCount);
                bfs(grid, r - 1, c, ROW, COL, queue, freshCount);
                bfs(grid, r, c + 1, ROW, COL, queue, freshCount);
                bfs(grid, r, c - 1, ROW, COL, queue, freshCount);
            }
            time++;
        }

        return freshCount[0] == 0 ? time : -1;
    }

    public void bfs(
        int[][] grid, int r, int c, int ROW, int COL, ArrayDeque<int[]> queue, int[] freshCount) {
        if (r < 0 || r >= ROW || c < 0 || c >= COL || grid[r][c] == 0 || grid[r][c] == 2) {
            return;
        }

        queue.add(new int[] {r, c});
        grid[r][c] = 2;
        freshCount[0] -= 1;
    }
}