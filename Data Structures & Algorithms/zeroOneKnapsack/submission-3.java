class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {       
        int ROW = profit.size();
        int COL = capacity;
        int[] dp = new int[COL+1];

         for(int c = 1; c <= COL; c++){
            if(weight.get(0) <= c ){
                dp[c] = profit.get(0);
            }
         }

         for(int row = 1; row < ROW; row++){
            int[] current = new int[COL+1];
            for(int col = 1; col <= COL; col++){
                int previousRowProfit = dp[col];
                int currentProfit = 0;
                if(weight.get(row) <= col){
                    currentProfit = profit.get(row) + dp[col-weight.get(row)];
                } 
                current[col] = Math.max(previousRowProfit, currentProfit);
            }
            dp = current;
         }

         return dp[COL];
    }
}
