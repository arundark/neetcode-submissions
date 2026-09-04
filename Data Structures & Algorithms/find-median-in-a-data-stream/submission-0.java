class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.add(num);

        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }

        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        }

        if (large.size() > small.size() + 1) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return (double) small.peek();
        }

        if (large.size() > small.size()) {
            return (double) large.peek();
        }

        return (double) (small.peek() + large.peek()) / 2;
    }
}
