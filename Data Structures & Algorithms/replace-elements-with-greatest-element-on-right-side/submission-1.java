class Solution {
    public int[] replaceElements(int[] arr) {
        // BF
        //  for (int i = 0; i< arr.length; i ++){
        //          int max = 0;
        //      for (int j = i+1; j < arr.length; j++){
        //              if (arr[j] > max)
        //                 max = arr[j];
        //      }
        //      arr[i] = max;
        //  }
        //  arr[arr.length-1] = -1;
        //  return arr;

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