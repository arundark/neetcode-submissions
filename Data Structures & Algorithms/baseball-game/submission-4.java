class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> score = new Stack<>();
        int sum = 0;
        for (String s : operations) {
            if (s.equals("+")) {
                int previous = score.pop();
                int beforePrevious = score.peek();
                int addition = beforePrevious + previous;
                score.push(previous);
                score.push(addition);
                sum += addition;
            } else if (s.equals("D")) {
                int doubleScore = 2 * score.peek();
                score.push(doubleScore);
                sum += doubleScore;
            } else if (s.equals("C")) {
                sum -= score.pop();
            } else {
                score.push(Integer.parseInt(s));
                sum += Integer.parseInt(s);
            }
        }

        return sum;
    }
}