class Solution {
    int mod=1000000007;
    public int countPathsWithXorValue(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
    
        int[][][]dp=new int[n][m][16];
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
             Arrays.fill(dp[i][j],-1);
           }
        }
        return dfs(grid,0,0,grid[0][0],k,dp);
    }
    public int dfs(int[][]grid,int row,int col,int xor,int k,int[][][]dp){
        if(row==grid.length-1&&col==grid[0].length-1){
            return xor==k?1:0;
        }

        if(dp[row][col][xor]!=-1){
            return dp[row][col][xor];
        }
        if(row<0||row>=grid.length||col<0||col>=grid[0].length){
            return 0;
        }
        long count=0;
        if(row+1<grid.length){
            count+=dfs(grid,row+1,col,grid[row+1][col]^xor,k,dp);
        }

        if(col+1<grid[0].length){
            count+=dfs(grid,row,col+1,grid[row][col+1]^xor,k,dp);
        }

        return dp[row][col][xor]=(int)count%mod;


    }
    
}