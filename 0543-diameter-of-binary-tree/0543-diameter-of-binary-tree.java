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
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        int total = left + right;
        
        int leftd = diameterOfBinaryTree(root.left);
        int rightd = diameterOfBinaryTree(root.right);
        
        int max = Math.max(total, Math.max(leftd, rightd));
        return max;
    }
    
    private static int height(TreeNode root) {
        
        if(root == null) return 0;
     
        int left = height(root.left);
        int right = height(root.right);
        
        return Math.max(left, right) + 1;
    }
}