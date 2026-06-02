class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int l = 0;
            int r = row.length - 1;

            while (l <= r) {
                int mid = (l + r) / 2;

                if (target > row[mid]) {
                    l = mid + 1;
                } else if (target < row[mid]) {
                    r = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
