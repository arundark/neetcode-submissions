class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permute = new ArrayList<>();
        permute.add(new ArrayList<>());

        for (int n : nums) {
            List <List<Integer>> currentPermute = new ArrayList<>();

            for (List<Integer> p : permute) {
                for (int i = 0; i < p.size() + 1; i++) {
                    List<Integer> copy = new ArrayList<>();
                    copy.addAll(p);
                    copy.add(i, n);
                    currentPermute.add(copy);
                }
            }

            permute = currentPermute;
        }

        return permute;
    }
}
