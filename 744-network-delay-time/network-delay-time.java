class Solution {
    class Pair{
        int time;int node;
        Pair(int node,int time){
            this.time=time;this.node=node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adj.get(u).add(new Pair(v,w));
        }

        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.time,b.time));
        int[]dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.add(new Pair(k,0));
        dist[k]=0;

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.node;
            int time=p.time;

            if(time>dist[node])continue;
            for(int i=0;i<adj.get(node).size();i++){
                int neighbour=adj.get(node).get(i).node;
                int ntime=adj.get(node).get(i).time;
                if(ntime+time<dist[neighbour]){
                    dist[neighbour]=ntime+time;
                    pq.add(new Pair(neighbour,ntime+time));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}