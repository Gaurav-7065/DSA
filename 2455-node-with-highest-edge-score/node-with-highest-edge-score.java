class Solution {
    public int edgeScore(int[] edges) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i]).add(i);
        }

        long ans=-1;
        long maxScore=Integer.MIN_VALUE;

        for(int i=0;i<adj.size();i++){
            long score=0;
            for(int sc:adj.get(i)){
                score+=sc;
            }
            if(score>maxScore){
               maxScore=score;
               ans=i;
            }
        }

     return (int)ans;

    }
}