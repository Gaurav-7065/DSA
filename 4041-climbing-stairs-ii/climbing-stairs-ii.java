class Solution {
    public int climbStairs(int n, int[] costs) {

        if (n == 0) return 0;

        int dp0 = 0;                 // dp[i-3]
        int dp1 = Integer.MIN_VALUE; // dp[i-2]
        int dp2 = 0; // dp[i-1]

        for (int i = 1; i <= n; i++) {

            int curr = dp2 + costs[i - 1] + 1;

            if (i >= 2)
                curr = Math.min(curr, dp1 + costs[i - 1] + 4);

            if (i >= 3)
                curr = Math.min(curr, dp0 + costs[i - 1] + 9);

            dp0 = dp1;
            dp1 = dp2;
            dp2 = curr;
        }

        return dp2;
    }
}