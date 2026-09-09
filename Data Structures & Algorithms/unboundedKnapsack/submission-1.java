class Solution {
    // Brute Force
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {        
        int[][] cache = new int[profit.size()][capacity+1];

        for(int r= 0 ; r < profit.size(); r++){
            Arrays.fill(cache[r], -1);
        }
        return dfs(0, profit, weight, capacity, cache);

    }

    public int dfs(int index, List<Integer> profit, List<Integer> weight, int capacity,  int[][] cache) {
        if (index == profit.size()) {
            return 0;
        }

        if(cache[index][capacity] != -1){
            return cache[index][capacity];
        }

        int notTake = 0 + dfs(index + 1, profit, weight, capacity, cache);

        int take = 0;

        if (weight.get(index) <= capacity) {
            take = profit.get(index) + dfs(index, profit, weight, capacity - weight.get(index), cache);
        }

        return cache[index][capacity] = Math.max(notTake, take);
    }
}
