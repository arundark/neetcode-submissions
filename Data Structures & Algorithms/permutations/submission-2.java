class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return helper(0, nums);
    }

    public List<List<Integer>> helper(int i, int[] nums) {
        if (i == nums.length) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> permutations = helper(i + 1, nums);
        List<List<Integer>> resPermutations = new ArrayList<>();
        for (List<Integer> p : permutations) {
            for (int j = 0; j < p.size() + 1; j++) {
                List<Integer> pCopy = new ArrayList<>();
                pCopy.addAll(p);
                pCopy.add(j, nums[i]);
                resPermutations.add(pCopy);
            }
        }

        return resPermutations;
    }
}
