class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (String c : operations) {
            if (c.equals("+")) {
                int previous1 = stack.pop();
                int previous2 = stack.peek();
                stack.push(previous1);
                stack.push(previous2 + previous1);
                sum += stack.peek();
            } else if (c.equalsIgnoreCase("C")) {
                sum -= stack.pop();
            } else if (c.equals("D")) {
                int previous = stack.peek();
                stack.push(previous * 2);
                sum += stack.peek();
            } else {
                stack.push(Integer.parseInt(c));
                sum += stack.peek();
            }
        }

        return sum;
    }
}