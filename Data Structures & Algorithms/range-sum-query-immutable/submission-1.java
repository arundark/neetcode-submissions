class NumArray {
    List<Integer> list = new ArrayList<>();
    public NumArray(int[] nums) {
        int total = 0;
        for(int num : nums){
            total += num;
            list.add(total);
        }
    }
    
    public int sumRange(int left, int right) {
        int rightPrefix = list.get(right);
        int leftPrefix =  left > 0? list.get(left-1) : 0;
        return (rightPrefix - leftPrefix);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */