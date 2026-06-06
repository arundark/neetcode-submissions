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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return hasPathSum(root, targetSum, sum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        if (root == null)
            return false;

        sum = sum + root.val;

        if (root.right == null && root.left == null) {
            if (sum == targetSum)
                return true;
            else {
                return false;
            }
        }

        if (hasPathSum(root.left, targetSum, sum)) {
            return true;
        }

        if (hasPathSum(root.right, targetSum, sum)) {
            return true;
        }

        //sum = sum - root.val;
        return false;
    }
}