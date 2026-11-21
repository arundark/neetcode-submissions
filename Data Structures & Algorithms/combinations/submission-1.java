class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> current = new ArrayList<>();
        dfs(current, 1, n, k);
        return result;
    }

    public void dfs(List<Integer> current, int i, int n, int k) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (i > n) {
            return;
        }

        for (int j = i; j < n + 1; j++) {
            current.add(j);
            dfs(current, j + 1, n, k);
            current.remove(current.size() - 1);
        }
    }
}