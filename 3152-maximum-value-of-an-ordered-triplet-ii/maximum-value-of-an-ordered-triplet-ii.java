class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long[]preMax=new long[n];
        preMax[0]=nums[0];
        for(int i=1;i<n;i++){
          preMax[i]=Math.max(preMax[i-1],nums[i]);
        }
        long[]sufMax=new long[n];
        sufMax[n-1]=nums[n-1];
        for(int i=n-2;i>0;i--){
            sufMax[i]=Math.max(sufMax[i+1],nums[i]);
        }
        long ans=0;
        for(int i=1;i<=n-2;i++){
            long l=preMax[i-1];
            long m=nums[i];
            long r=sufMax[i+1];

            long val=(l-m)*r;
            ans=Math.max(ans,val);
        }
        return ans<0?-1:ans;
    }
}