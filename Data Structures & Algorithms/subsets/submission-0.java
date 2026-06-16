class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> array = new ArrayList<>();
        int length = 0;
        subsets(nums, length, array);
        return list;
    }

    public void subsets(int[] nums, int length, List<Integer> array ){
        if (length == nums.length){
            list.add(new ArrayList<Integer>(array));
            return;
        }

        array.add(nums[length]);
        subsets(nums, length+1, array);
        array.remove(array.size()-1);
        subsets(nums, length+1, array);

    }
}
