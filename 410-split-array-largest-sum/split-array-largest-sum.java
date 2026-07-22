class Solution {
    public int helper(int[]nums,int mid){
        int cnt=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
          if(sum+nums[i]<=mid){
            sum+=nums[i];
          }
          else{
            cnt++;
            sum=nums[i];
           }
        }
        return cnt;
    }
    public int splitArray(int[] nums, int k) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
           sum+=nums[i];
           max=Math.max(nums[i],max);
        }
        int low=max;
        int high=sum;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int val=helper(nums,mid);
            if(val<=k){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
      return ans;

    }
}