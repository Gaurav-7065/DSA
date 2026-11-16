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
    public int maxi=0;
    public int solve(TreeNode node){
        if(node==null)return 0;
        int lh=solve(node.left);
        int rh=solve(node.right);
        maxi=Math.max(lh+rh,maxi);
        return 1+Math.max(lh,rh);
    }
  
    
   
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        solve(root);
        return maxi;
    }
}