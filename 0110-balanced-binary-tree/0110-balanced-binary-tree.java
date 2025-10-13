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
    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        if(height==-1){
            return false;
        }
        return true;
    }
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSubtreeHeight = getHeight(root.left);
        int rightSubtreeHeight = getHeight(root.right);
        if(leftSubtreeHeight==-1 || rightSubtreeHeight==-1){
            return -1;
        }
        if(Math.abs(leftSubtreeHeight - rightSubtreeHeight)>1){
            return -1;
        }
        return 1+Math.max(leftSubtreeHeight, rightSubtreeHeight);

    }
}