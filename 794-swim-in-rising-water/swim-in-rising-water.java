class Solution {
    class Pair{
        int r;
        int c;
        int d;
        Pair(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;int m=grid[0].length;
        int[][]dist=new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.d,b.d));
        dist[0][0]=grid[0][0];
        pq.add(new Pair(0,0,0));
        int[]drow={-1,0,1,0};
        int[]dcol={0,1,0,-1};

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int r=p.r;
            int c=p.c;
            int d=p.d;
            if(dist[r][c]<d)continue;
            for(int i=0;i<4;i++){
              int nrow=drow[i]+r;
              int ncol=dcol[i]+c;
              if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m){
                 if(dist[nrow][ncol]>dist[r][c]+d){
                  dist[nrow][ncol]= Math.max(dist[r][c], grid[nrow][ncol]);
                  pq.add(new Pair(nrow,ncol,dist[nrow][ncol]));
                 }
              }
              
            }
        }

       return dist[n-1][m-1];
    }
}