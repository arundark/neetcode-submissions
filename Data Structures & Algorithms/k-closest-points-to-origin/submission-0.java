class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for (int[] point : points) {
            int distance = (point[0] * point[0]) + (point[1] * point[1]);
            queue.offer(new int[] {distance, point[0], point[1]});
        }

        int[][] results = new int[k][2];

        int i = 0;
        while (k > 0) {
            int[] point = queue.poll();
            results[i++] = new int[] {point[1], point[2]};
            k--;
        }
        return results;
    }
}
