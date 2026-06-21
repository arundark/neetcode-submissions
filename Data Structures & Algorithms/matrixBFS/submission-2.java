class Solution {
    public int shortestPath(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int ROW = grid.length;
        int COL = grid[0].length;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] visit = new int[ROW][COL];

        queue.add(new int[2]);
        visit[0][0] = 1;
        int length = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rc = queue.poll();
               int r = rc[0];
               int c = rc[1];

                if(r == ROW-1 && c == COL-1) return length;

                addPath(grid, r+1,c,ROW,COL,visit,queue);
                addPath(grid, r-1,c,ROW,COL,visit,queue);
                addPath(grid, r,c+1,ROW,COL,visit,queue);
                addPath(grid, r,c-1,ROW,COL,visit,queue);
                
            }
            length++;
        }
        return -1;
    }

    public void addPath(int[][] grid, int r, int c, 
    int ROW, int COL, int[][] visit, ArrayDeque<int[]> queue) {
         if(r < 0 || r >= ROW || c <0 || c>=COL || grid[r][c] == 1 || visit[r][c] == 1 ){
            return;
         }
        queue.add(new int[]{r,c});
        visit[r][c] = 1;
    }
}
