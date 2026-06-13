class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length - 1;
        int left = 0;

        while (left <= length) {
            int[] arr = matrix[left];

            if (target <= arr[arr.length - 1]) {
                int l = 0;
                int r = arr.length - 1;
                while (l <= r) {
                    int m = (l + r) / 2;
                    if (target > arr[m]) {
                        l = m + 1;
                    } else if (target < arr[m]) {
                        r = m - 1;
                    } else {
                        return true;
                    }
                }

                return false;

            } else {
                left++;
            }
        }
        return false;
    }
}
