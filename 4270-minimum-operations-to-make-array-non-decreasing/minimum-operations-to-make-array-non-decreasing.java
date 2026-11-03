class Solution {
   
    public long minOperations(int[] nums) {
        int n=nums.length;
        long sum=0;
        long prev=0;
        for(int i=1;i<n;i++){
            long curr=(long)Math.max(0L,prev+(long)(nums[i-1]-nums[i]));
            if(curr>prev){
               sum+=Math.max(0,curr-prev);
            }
            else{
                prev=curr;
            }
        }
        return sum;
    }
   
}