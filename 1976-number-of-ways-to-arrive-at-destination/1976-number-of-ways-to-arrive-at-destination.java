class Solution {
    static long MOD=(int)1e9;
    static class Pair{
        int node;
        long dist;
        public Pair(int node, long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        long[] distance =new long[n+1];
        long[] ways=new long[n+1];

        Arrays.fill(distance,Long.MAX_VALUE);
        Arrays.fill(ways,0);

        distance[0]=0;
        ways[0]=1;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.dist, b.dist));
        pq.offer(new Pair(0,0));
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            long w=roads[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.node;
            long d=curr.dist;
            if(d>distance[u]) continue; // very important
            for(Pair p:adj.get(u)){
                int v=p.node;
                long weight=p.dist;
                if(distance[v]>distance[u]+weight){
                    distance[v]=distance[u]+ weight;
                    ways[v]=ways[u];
                    pq.offer(new Pair(v, distance[v]));
                }else if(distance[v]==distance[u]+weight){
                    ways[v]=(ways[u]+ways[v])%MOD;
                }
            }
        }
        return (int)ways[n-1];
    }
}