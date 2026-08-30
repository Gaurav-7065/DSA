class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }

        if(Math.abs(target)>sum||(sum+target)%2!=0){
            return 0;
        }

        int pos=(sum+target)/2;
        int n=nums.length;
        int[][]dp=new int[n+1][pos+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(nums,pos,0,dp);
    }
    static int dfs(int[]arr,int target,int idx,int[][]dp){
       
        if(idx==arr.length){
            return target==0?1:0;
            
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target];
        }
        int yes=0;
        if(arr[idx]<=target){
            yes=dfs(arr,target-arr[idx],idx+1,dp);
        }
        int no=dfs(arr,target,idx+1,dp);
        return dp[idx][target]=yes+no;
    }
}