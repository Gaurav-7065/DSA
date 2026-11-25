class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxi=0;
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] != '0') {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
            maxi=Math.max(maxi,dp[0][i]);
        }
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] != '0') {
                dp[i][0] = 1;
            }
            else{
                dp[i][0]=0;
            }
            maxi=Math.max(maxi,dp[i][0]);
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                int min = Integer.MAX_VALUE;
                min = Math.min(min, dp[i - 1][j]);
                min = Math.min(min, dp[i - 1][j - 1]);
                min = Math.min(min, dp[i][j - 1]);
                if (matrix[i][j] != '0') {
                    dp[i][j] = min + 1;
                }
                maxi=Math.max(maxi,dp[i][j]);
            }
            
        }
        
        
        return maxi*maxi;
    }
}