class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int length = 0;
        dfs(nums, length, list);

        return result;

    }

    public void dfs(int[] nums, int length, List<Integer> list){
        if(length == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        list.add(nums[length]);
        dfs(nums, length+1, list);
        list.remove(list.size()-1);
        dfs(nums,length+1,list);


    }
}
