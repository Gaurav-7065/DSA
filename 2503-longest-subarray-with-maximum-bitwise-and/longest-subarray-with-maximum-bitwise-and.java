class Solution {
    public int longestSubarray(int[] nums) {
       
        int n=nums.length;
        int max=Integer.MIN_VALUE;
       for(int num:nums){
          max=Math.max(num,max);
       }
        int count=1;
        int low=0;
        int high=0;
        while(high<n){
            while(high<n&&nums[low]-nums[high]!=0){
                low++;
                
            }
            if(nums[low]==max){
                count=Math.max(high-low+1,count);
            }
            high++;
        }
        return count;
    }
}