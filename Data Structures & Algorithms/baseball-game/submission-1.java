class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String c : operations) {
            if (c.equals("+")) {
                int previous1 = stack.pop();
                int previous2 = stack.pop();
                stack.push(previous2);
                stack.push(previous1);
                stack.push(previous2 + previous1);
            } else if (c.equalsIgnoreCase("C")) {
                stack.pop();
            } else if (c.equals("D")) {
                int previous = stack.peek();
                stack.push(previous * 2);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}