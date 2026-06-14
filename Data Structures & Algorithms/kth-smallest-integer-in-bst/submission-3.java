/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count = 0;
    int val = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        count = k;
        dfs(root);
        return val;
    }

    public void dfs(TreeNode root){
        if(root == null || count <= 0) return;

        dfs(root.left);
        count = count - 1;
        if(count == 0){
            val = root.val;
            return;
        }
        dfs(root.right);
    }
}
