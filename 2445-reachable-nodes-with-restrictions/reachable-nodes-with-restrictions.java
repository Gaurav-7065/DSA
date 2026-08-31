class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[]vis=new int[n];
        for(int i=0;i<restricted.length;i++){
            vis[restricted[i]]=-1;
        }

        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        vis[0]=1;

        while(!q.isEmpty()){
            int node=q.poll();
       
            for(int i=0;i<adj.get(node).size();i++){
                int neighbour=adj.get(node).get(i);
                if(vis[neighbour]==0){
                    vis[neighbour]=1;
                    q.add(neighbour);
                }
            }
        }
        int count=0;
        for(int i=0;i<vis.length;i++){
            if(vis[i]==1){
                count++;
            }
        }
        return count;
    }
}