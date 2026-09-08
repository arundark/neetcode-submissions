class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {       
        int ROW = profit.size();
        int COL = capacity;
        int[][] dp = new int[ROW][COL+1];

         for(int c = 1; c <= COL; c++){
            if(weight.get(0) <= c ){
                dp[0][c] = profit.get(0);
            }
         }

         for(int row = 1; row < ROW; row++){
            for(int col = 1; col <= COL; col++){
                int previousRowProfit = dp[row-1][col];
                int currentProfit = 0;
                if(weight.get(row) <= col){
                    currentProfit = profit.get(row) + dp[row-1][col-weight.get(row)];
                } 
                dp[row][col] = Math.max(previousRowProfit, currentProfit);
            }
         }

         return dp[ROW-1][COL];
    }
}
