class MinStack {
        ArrayList<Integer> stack; 
        ArrayList<Integer> minStack; 
        int index = 0;
    public MinStack() {
        stack= new ArrayList();
        minStack = new ArrayList();
    }
    
    public void push(int val) {
        stack.add(val);
        if (index == 0 || val <= minStack.get(index - 1)) {
            minStack.add(val);
        } else {
            minStack.add(minStack.get(index - 1));
        }
        index++;
    }
    
    public void pop() {
        stack.remove(index - 1);
        minStack.remove(index - 1);
        index--;
    }
    
    public int top() {
        return stack.get(index-1);
    }
    
    public int getMin() {
        return minStack.get(index - 1);
    }
}