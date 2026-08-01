class Solution {
    class Pair{
        int row;
        int col;
        int tm;
        Pair(int row,int col,int tm){
            this.row=row;
            this.col=col;
            this.tm=tm;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        int[][]vis=new int[n][m];
        int tm=0;
        
        int cntfresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(grid[i][j]==2){
                  vis[i][j]=2;
                  q.offer(new Pair(i,j,0));
               } 
               else if(grid[i][j]==1){
                cntfresh++;
               }
               else{
                 vis[i][j]=0;
               }
            }
        }
        int[]drow={-1,0,1,0};
        int[]dcol={0,1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            q.poll();
            tm=Math.max(tm,t);

            for(int i=0;i<4;i++){
                int row=r+drow[i];
                int col=c+dcol[i];
                
                if(row>=0&&row<n&&col>=0&&col<m
                &&vis[row][col]==0&&grid[row][col]==1){
                    q.add(new Pair(row,col,t+1));
                    vis[row][col]=2;
                    cnt++;
                }
            }
        }
       if(cnt!=cntfresh) return -1;
       return tm;
    }
}