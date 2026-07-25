class Solution {
    public int helper(int[][]matrix,int guess){
        int n=matrix.length;
        int count=0;
        int row=n-1; int col=0;

        while(row>=0 && col<n){
            if(matrix[row][col]<=guess){
                count+=(row+1);
                col++;
            }
            else{
                row--;
            }
            
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
       int n=matrix.length;
       int low=1;
       int high=matrix[n-1][n-1];
       int res=matrix[0][0];
       while(low<=high){
          int guess=(low+high)/2;
          int ans=helper(matrix,guess);

          if(ans>=k){
             res=guess;
             high=guess-1;
          }
          else{
            low=guess+1;
          }
       }
       return res;
    }
}