class Solution {
    // tabulation
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {        int ROW = profit.size();
         int COL = capacity;
        int[][] cache = new int[ROW][COL+1];

        for(int c= 1 ; c <= COL ; c++){
            if(weight.get(0) <= c){
                cache[0][c] = (c / weight.get(0)) * profit.get(0);
            }
        }
       
       for(int row = 1; row < ROW; row++){
         for(int col = 1; col <= COL; col++){
            int previousRowProfit = cache[row-1][col];
            int currentProfit = 0;

            if(weight.get(row) <= col){
                currentProfit = profit.get(row) + cache[row][col - weight.get(row)];
            }
            cache[row][col] = Math.max(previousRowProfit, currentProfit);
         }
       }

       return cache[ROW-1][COL];

    }

}
