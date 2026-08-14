class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] previousRow = new int[n];

        for (int i = m - 1; i >= 0; i--) {
            int[] currentRow = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    currentRow[j] = 0;
                } else if (i == m - 1 && j == n - 1) {
                    currentRow[j] = 1;
                } else {
                    int right = (j + 1 < n) ? currentRow[j + 1] : 0;
                    //int down = (i + 1 < m) ? previousRow[j] : 0;
                    currentRow[j] = right + previousRow[j];
                }
            }
            previousRow = currentRow;
        }

        return previousRow[0];
    }
}