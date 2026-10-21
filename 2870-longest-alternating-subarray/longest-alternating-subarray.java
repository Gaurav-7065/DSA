class Solution {
    public int alternatingSubarray(int[] nums) {
        int n=nums.length;
        int ans=-1;
        for(int i=0;i<n;i++){
            int  order=1;
            int j=i;
            while(j<n-1){
                if(order==1&&nums[j]+1!=nums[j+1]){
                    break;
                }
                else if(order==0&&nums[j]-1!=nums[j+1]){
                    break;
                }
                order=Math.abs(order-1);
                j++;
            }
            if(j==i)continue;
            ans=Math.max(ans,j-i+1);

        }
        return ans;
    }
}