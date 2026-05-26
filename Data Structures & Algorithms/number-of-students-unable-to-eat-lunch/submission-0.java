class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> sandwich = new Stack<>();
        LinkedList<Integer> student = new LinkedList<>();
        int count = 0;

        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwich.push(sandwiches[i]);
        }
        for (int s : students) {
            student.add(s);
        }

        while (!student.isEmpty() && count < student.size()) {
            if (student.peek().equals(sandwich.peek())) {
                student.remove();
                sandwich.pop();
                count = 0;
            } else {
                student.add(student.remove());
                count++;
            }
        }
        return student.size();
    }
}