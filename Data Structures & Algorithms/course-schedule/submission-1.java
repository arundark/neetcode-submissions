class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap();
    HashSet<Integer> visit = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            map.get(prereq[0]).add(prereq[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int course) {
        if (visit.contains(course)) {
            return false;
        }
        if (map.get(course).isEmpty()) {
            return true;
        }
        visit.add(course);

        for (int pre : map.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visit.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}
