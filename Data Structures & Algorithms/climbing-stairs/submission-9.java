class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n];
        return climbStairs(n, 0);
    }

    public int climbStairs(int n, int i) {
        if (i == n)
            return 1;
        if (i > n)
            return 0;

        if (cache[i] != 0)
            return cache[i];

        return cache[i] = climbStairs(n, i + 1) + climbStairs(n, i + 2);
    }
}
