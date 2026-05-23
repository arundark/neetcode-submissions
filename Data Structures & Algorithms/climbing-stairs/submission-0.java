class Solution {
    public int climbStairs(int n) {
       int output= count(0,n);
       return output;
    }

    private int count(int steps,int n){
        if(steps>n) return 0;

        if(steps == n) return 1;

        int oneStep = count(steps+1, n);
        int twoStep = count(steps+2, n);

        return oneStep+twoStep;

    }
}
