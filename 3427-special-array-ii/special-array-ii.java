class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int[]bad=new int[n];

        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                bad[i]=1;
            }
        }

        boolean[] ans = new boolean[m];
        int[]prefixSum=new int[n];
        prefixSum[0]=0;
        for(int i=1;i<prefixSum.length;i++){
            prefixSum[i]=prefixSum[i-1]+bad[i];
        }
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
             
             int validation=prefixSum[r]-prefixSum[l];
             ans[i]=validation==0;
            }
            return ans;
        }
}