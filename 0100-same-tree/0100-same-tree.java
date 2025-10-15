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
    public boolean isSameTree(TreeNode p, TreeNode q) {
    //     List<Integer> pPre=new ArrayList<>();
    //     List<Integer> qPre=new ArrayList<>();
    //     preorder(p,pPre);
    //     preorder(q,qPre);
    //     return pPre.equals(qPre);
    // }

    // public void preorder(TreeNode root, List<Integer> list) {
    //     if(root==null) {
    //     list.add(null);
    //     return ;}

    //     list.add(root.val);
    //     preorder(root.left,list);
    //     preorder(root.right,list);


    //if both root are null ,they are same
    if(p==null && q==null) return true;
    if(p==null || q==null) return false;
    
    if(p.val!=q.val) return false;
    return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    
    }
}
