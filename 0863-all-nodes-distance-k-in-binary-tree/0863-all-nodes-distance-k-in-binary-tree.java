/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode , TreeNode > map=new HashMap<>();
        buildParentMap(root, null , map);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        Set<TreeNode> vis=new HashSet<>();
        vis.add(target);
        int distance=0;

        //level order
        while(!q.isEmpty()){
            int size=q.size();
            if(distance==k) break;
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
                distance++;
               
            }
           
       
        }
         List<Integer> ans=new ArrayList<>();
            while(!q.isEmpty()){
                ans.add(q.poll().val);
            }
        return ans;
    }

    public void buildParentMap(TreeNode node, TreeNode parent, HashMap<TreeNode , TreeNode > map){
        if(node==null){
            return;
        }
        map.put(node,parent);
        buildParentMap(node.left,node,map);
        buildParentMap(node.right,node,map);

    }
}