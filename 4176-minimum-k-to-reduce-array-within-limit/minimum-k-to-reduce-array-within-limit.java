class Solution {
    public int nonPos(int[]nums,long k){
        int opn=0;
        for(int i=0;i<nums.length;i++){
            int elem=nums[i];
            opn+=(int)Math.ceil((double)elem/k);
        }

        return opn;
    }
    public int minimumK(int[] nums) {
        long sum=0;
        for(int num:nums){
           sum+=num;
        }

        
        long low=1;long high=sum;
        int ans=1;
        while(low<=high){
            long mid=(low+high)/2;
            int opn=nonPos(nums,mid);
            if(opn<=1L*mid*mid){
                
                high=mid-1;
                ans=(int)mid;
            }
            else{
                low=mid+1;
            }
        }

        return ans;
        
    }
}