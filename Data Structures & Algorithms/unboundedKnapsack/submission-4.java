class Solution {
    // tabulation space optimised
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {        int ROW = profit.size();
         int COL = capacity;
        int[] cache = new int[COL+1];

        for(int c= 1 ; c <= COL ; c++){
            if(weight.get(0) <= c){
                cache[c] = (c / weight.get(0)) * profit.get(0);
            }
        }
       
       for(int row = 1; row < ROW; row++){
        int[] currentRow = new int[COL+1];
         for(int col = 1; col <= COL; col++){
            int previousRowProfit = cache[col];
            int currentProfit = 0;

            if(weight.get(row) <= col){
                currentProfit = profit.get(row) + currentRow[col - weight.get(row)];
            }
            currentRow[col] = Math.max(previousRowProfit, currentProfit);
         }
         cache = currentRow;
       }

       return cache[COL];

    }

}
