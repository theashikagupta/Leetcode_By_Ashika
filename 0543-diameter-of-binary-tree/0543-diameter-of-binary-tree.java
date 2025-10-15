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
    public int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
    //     //O(n^2)
    //     if(root==null) return 0;

    //     int leftDia=diameterOfBinaryTree(root.left);
    //     int rightDia=diameterOfBinaryTree(root.right);
    //     int currDia=height(root.left)+height(root.right);  //leftHeight + rightHeight

    //     return Math.max(Math.max(leftDia,rightDia),currDia);
    // }
    // public int height(TreeNode root){
    //     if(root==null) return 0;
    //     int lH=height(root.left);
    //     int rH=height(root.right);
    //     int maxH=Math.max(lH,rH)+1;
    //     return maxH;

        height(root);
        return diameter;
    }
    public int height(TreeNode root){
       
        if(root==null) return 0;
       
        int lH=height(root.left);
        int rH=height(root.right);
        diameter=Math.max(diameter,lH+rH);
        int maxH=Math.max(lH,rH)+1;
        return maxH;
    }
}