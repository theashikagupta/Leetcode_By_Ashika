class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int V=numCourses;
        int edges=prerequisites.length;

        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adjList.get(v).add(u);
           
        }
        
        int[] indegree=new int[V];
        for(int i=0; i<edges.length; i++){
            int u=edges[i][0];
            indegree[u]++;   
        }

        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0){
                q.offer(i);
                
            }
        }
        
        while(!q.isEmpty()){
            int curr=q.poll();
            ans.add(curr);
            for(int nei : adjList.get(curr)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.offer(nei);
                }
                   
            }
        }
        
        return (V==ans.size());

        
    }
}