class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();

        dfs(1, n, k, list);

        return result;
    }

    public void dfs(int i, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (i > n) {
            return;
        }

        for (int j = i; j <= n; j++) {
            list.add(j);
            dfs(j + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}