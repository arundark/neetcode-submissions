class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxLeftHeight = height[l];
        int maxrightHeight = height[r];
        int totalArea = 0;

        while (l < r) {
            int currentUnit = 0;
            if (maxLeftHeight < maxrightHeight) {
                l++;
                currentUnit = maxLeftHeight - height[l];
                maxLeftHeight = Math.max(maxLeftHeight, height[l]);
            } else {
                r--;
                currentUnit =  maxrightHeight - height[r];
                maxrightHeight = Math.max(maxrightHeight, height[r]);
            }
            totalArea = (currentUnit > 0) ? currentUnit + totalArea : totalArea;
        }
        return totalArea;
    }
}
