class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[]drow={-1,0,1,0};
        int[]dcol={0,1,0,-1};
        boolean[][]vis=new boolean[n][m];
        for(int i=0;i<m;i++){
            if(vis[0][i]==false&&board[0][i]=='O'){
                dfs(0,i,vis,board,drow,dcol);
            }
            if(vis[n-1][i]==false&&board[n-1][i]=='O'){
                dfs(n-1,i,vis,board,drow,dcol);
            }
        }

        for(int i=0;i<n;i++){
            if(vis[i][0]==false&&board[i][0]=='O'){
                dfs(i,0,vis,board,drow,dcol);
            }
            if(vis[i][m-1]==false&&board[i][m-1]=='O'){
                dfs(i,m-1,vis,board,drow,dcol);
            }
        }
      
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(vis[i][j]==false&&board[i][j]=='O'){
                board[i][j]='X';
            }
            
        }
      }
        
    }
    private void dfs(int row,int col,boolean[][]vis,char[][]board,int[]drow,int[]dcol){

        vis[row][col]=true;
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];

            if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==false&&board[nrow][ncol]=='O'){
                vis[nrow][ncol]=true;
                dfs(nrow,ncol,vis,board,drow,dcol);
            }
        }
    }
}