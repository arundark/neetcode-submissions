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
    public TreeNode minNode(TreeNode root){
        //if(current == null) return current;
        TreeNode current = root;
        while(current != null && current.left != null){
            current = current.left;
        }

        return current;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else if (key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                TreeNode min = minNode(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right,min.val);
            }
        }
        return root;
    }
}