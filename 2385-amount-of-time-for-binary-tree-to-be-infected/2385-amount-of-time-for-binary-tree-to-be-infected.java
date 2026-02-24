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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode , TreeNode > map=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode startNode= buildParentMap(root, start,null , map);
        q.offer(startNode);
        Set<TreeNode> vis=new HashSet<>();
        vis.add(startNode);
        int time=0;

        while(!q.isEmpty()){
            int size=q.size();
           
            
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && !vis.contains(curr.left)){
                    vis.add(curr.left);
                    q.offer(curr.left);
                
                }
                if(curr.right!=null && !vis.contains(curr.right)){
                    vis.add(curr.right);
                    q.offer(curr.right);
                }
                TreeNode parent=map.get(curr);
                if(parent!=null && !vis.contains(parent)){
                    vis.add(parent);
                    q.offer(parent);
                }
              
               
            }
            time++;
        }
        return time-1;
    }

    public TreeNode buildParentMap(TreeNode node,int start, TreeNode parent, HashMap<TreeNode , TreeNode > map){
        if(node==null){
            return null;
        }
        if(node.val==start){
            return node;
        }
        map.put(node,parent);
        TreeNode left = buildParentMap(node.left, start, node, map);
    if (left != null) return left;

    return buildParentMap(node.right, start, node, map);
       
        
    }
    
}