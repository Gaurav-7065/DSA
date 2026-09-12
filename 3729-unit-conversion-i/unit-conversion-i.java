class Solution {
    int mod=1000000007;
    class Pair{
        int target;
        int factor;
        Pair(int target,int factor){
            this.target=target;
            this.factor=factor;
        }
    }
    public int[] baseUnitConversions(int[][] conversions) {
        int n=conversions.length+1;
        ArrayList<ArrayList<Pair>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<conversions.length;i++){
            int src=conversions[i][0];
            int target=conversions[i][1];
            int factor=conversions[i][2];
            graph.get(src).add(new Pair(target,factor));
        }

        int[]ans=new int[n];
        ans[0]=1;
        dfs(0,graph,ans);
        return ans;
    }
    void dfs(int src,ArrayList<ArrayList<Pair>>graph,int[]ans){
          
         for(int i=0;i<graph.get(src).size();i++){
            Pair p=graph.get(src).get(i);
            int target=p.target;
            int factor=p.factor;
            ans[target]=(int)((long)ans[src]*factor%mod);
            dfs(target,graph,ans);
         }
    }
}