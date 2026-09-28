class Solution {
    public int orangesRotting(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        int fresh = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int time = 0;
        while (fresh > 0 && !queue.isEmpty()) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                int[] rc = queue.poll();
                int r = rc[0];
                int c = rc[1];

                int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if (row < 0 || row >= ROW || col < 0 || col >= COL || grid[row][col] != 1) {
                        continue;
                    }

                    grid[row][col] = 2;
                    queue.add(new int[] {row, col});
                    fresh--;
                }
            }
            time++;
        }

        return (fresh == 0) ? time : -1;
    }
}
