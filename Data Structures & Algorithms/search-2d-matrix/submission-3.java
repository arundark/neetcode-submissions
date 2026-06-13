class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        while (top <= bottom) {
            int row = (top + bottom) / 2;
            int start = 0;
            int end = matrix[row].length - 1;

            if (target < matrix[row][start]) {
                bottom = row - 1;
            } else if (target > matrix[row][end]) {
                top = row + 1;
            } else {
                while (start <= end) {
                    int mid = (start + end) / 2;

                    if (target < matrix[row][mid]) {
                        end = mid - 1;
                    } else if (target > matrix[row][mid]) {
                        start = mid + 1;
                    } else {
                        return true;
                    }
                }
                return false;
            }
        }

        return false;
    }
}
