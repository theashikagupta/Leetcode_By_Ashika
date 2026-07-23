class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            int from=flight[0];
            int to=flight[1];
            int cost=flight[2];
            adj.get(from).add(new int[]{to,cost});

        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{src,0});
        dist[src]=0;
        int stops=-1;

        while(!q.isEmpty() && stops<=k){
            int size=q.size();
            for(int i=0; i<size; i++){
               int[] curr=q.poll();
               int u=curr[0];
               int c=curr[1];

               for(int[] nei:adj.get(u)){
                 int v=nei[0];
                 int cost=nei[1];
                 if(dist[v]>c+cost   && stops+1<=k){
                    dist[v]=c+cost;
                    q.offer(new int[]{v,dist[v]});
                 } 
               }
            }
             stops++;
        }
            
           
            
        
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}