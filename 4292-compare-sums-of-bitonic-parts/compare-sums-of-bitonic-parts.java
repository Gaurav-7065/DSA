class Solution {
    public int compareBitonicSums(int[] nums) {
        long aSum=nums[0];
        long dSum=0;
        int n=nums.length;
        int peak=0;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                if(nums[i]>nums[i+1]&&nums[i]>nums[i-1]){
                    peak=i;
                }
                aSum+=nums[i];
            }
            else{
                
                dSum+=nums[i];
            }
        }
        dSum+=nums[peak];
        if(aSum==dSum){
            return -1;
        }
        else if(aSum>dSum){
            return 0;
        }
        else {
            return 1;
        }
    }
}