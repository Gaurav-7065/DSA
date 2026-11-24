class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(coins, 0, dp, amount);
    }

    public int dfs(int[] coins, int idx, int[][] dp, int amount) {
        if (amount == 0) {
            return 1;
        }
        if ( idx>coins.length-1) {
            return 0;
        }
        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }
        int ways1=0;
        if (coins[idx] <= amount) {
           
           ways1=dfs(coins, idx, dp, amount - coins[idx]);
           
          
        }
        int ways2=dfs(coins,idx+1,dp,amount);

        return dp[idx][amount]=ways1+ways2;
        
    }
}