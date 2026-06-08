class Solution {
    public int[] replaceElements(int[] arr) {
        //OP
        int n = arr.length - 1;
        int max = arr[n];
        arr[n] = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                int swap = max;
                max = arr[i];
                arr[i] = swap;
            } else {
                arr[i] = max;
            }
        }

        return arr;
    }
}