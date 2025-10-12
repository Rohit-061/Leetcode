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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root == null){
            return ans;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<n ; i++){
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }

            }
            ans.add(level);
        }
        return ans;

    }
}