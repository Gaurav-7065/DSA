class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);

        }
        long[]dp=new long[n];
        Arrays.fill(dp,-1);
        long[]ft=new long[n];
        long ans=dfs(0,edges,baseTime,ft,adjList,dp);
        return ans;
        
    }
    public long dfs(int p,int[][]edges,int[]bt,long[]ft,List<List<Integer>> adjList,long[]dp){
        if(adjList.get(p).size()==0){
            ft[p]=bt[p];
            dp[p]=bt[p];
            return ft[p];
        }
        if(dp[p]!=-1){
            return dp[p];
        }
        int parent=p;
        long early=Long.MAX_VALUE;
        long latest=Long.MIN_VALUE;
        for(int i=0;i<adjList.get(p).size();i++){
           int child=adjList.get(p).get(i);
           early=Math.min(early,dfs(child,edges,bt,ft,adjList,dp));
           latest=Math.max(latest,dfs(child,edges,bt,ft,adjList,dp));
        }
        long od=(latest-early)+bt[p];
       
         ft[p]=latest+od;
         dp[p]=ft[p];
         return dp[p];
    }
}