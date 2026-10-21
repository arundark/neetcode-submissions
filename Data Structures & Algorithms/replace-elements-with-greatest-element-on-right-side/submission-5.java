class Solution {
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        int maxRight = arr[length-1];
        arr[length-1] = -1;

        for(int i = length -2; i >=0; i--){
            int tmp = arr[i];
            arr[i] = maxRight;
            maxRight = Math.max(maxRight, tmp);
        }

        return arr;
    }
}