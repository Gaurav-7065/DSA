class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size();
        int ans=0;
        int currLen=1;
        int prevLen=0;
        for(int i=1;i<n;i++){
           if(nums.get(i)>nums.get(i-1)){
             currLen++;

           }
           else{
            prevLen=currLen;
            currLen=1;
           }
           int k=Math.max(currLen/2,Math.min(currLen,prevLen));
           ans=Math.max(ans,k);
        }
        return ans;
    }
}