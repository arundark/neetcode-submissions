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
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(
        int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (prestart > preend || instart > inend)
            return null;

        TreeNode root = new TreeNode(preorder[prestart]);

        int inRootIndex = map.get(root.val);
        int inLeftCount = inRootIndex - instart;

        root.left = buildTree(
            preorder, prestart + 1, prestart + inLeftCount, inorder, instart, inRootIndex - 1);

        root.right = buildTree(preorder, prestart+inLeftCount+1, preend, inorder, inRootIndex+1, inend);

        return root;    
    }
}
