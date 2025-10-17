class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else { // root.val == key
            // Case 1: No child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            // Case 2: Two children
            TreeNode inorderSucc = getSucc(root);
            root.val = inorderSucc.val; // copy successor's value
            root.right = deleteNode(root.right, inorderSucc.val); // delete successor
        }
        return root;
    }
    
    // Get inorder successor (smallest node in right subtree)
    private TreeNode getSucc(TreeNode root) {
        TreeNode curr = root.right;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}
