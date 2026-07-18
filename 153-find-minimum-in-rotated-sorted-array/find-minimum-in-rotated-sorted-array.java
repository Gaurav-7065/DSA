class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(nums[0]<nums[n-1]) return nums[0];
        int ans=Integer.MAX_VALUE;
        int low=0;int high=n-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=nums[low]){
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }
            else{
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }
        }
        return ans;
    }
}