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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> result = inorderTraversal(root);
        return solve(0,result.size()-1,result);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {

        if (root == null) return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
    private TreeNode solve(int l,int r,List<Integer> result){
        if(l>r) return null;

        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(result.get(mid));
        root.left=solve(l,mid-1,result);
        root.right=solve(mid+1,r,result);
        return root;
    }
    
}