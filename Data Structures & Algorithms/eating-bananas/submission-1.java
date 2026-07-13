class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int k = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long totalHour = 0;
            for (int i = 0; i < piles.length; i++) {
                totalHour += (piles[i] + mid - 1) / mid;
            }

            if (totalHour <= h) {
                k = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return k;
    }
}
