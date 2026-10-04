class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for( int i =0 ; i<=n; i++){
            int k = i;
            int count = 0;
            while(k > 0){
                if((k & 1) == 1){
                    count++;
                }
                k = k >> 1;
            }
            result[i] = count;
        }

        return result;
    }
}
