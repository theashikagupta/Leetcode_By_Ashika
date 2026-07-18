class Solution {
    public int[] findOrder(int V, int[][] grid) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int m=grid.length;
        
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[V];
        for(int i=0; i<m; i++){
            int u=grid[i][0];
            int v=grid[i][1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        ArrayList<Integer> topo=new ArrayList<>();
        while(!queue.isEmpty()){
            int curr=queue.poll();
            topo.add(curr);
            for(int nei: adj.get(curr)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    queue.offer(nei);
                   
                }
            }                    
        }
        int[] ans=new int[topo.size()];
        for(int i=0; i<topo.size(); i++){
            ans[i]=topo.get(i);
        }
        return (ans.length!=V)?new int[]{}:ans;
    }
}