class Solution {
    public long maxStrength(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        List<Integer>neg=new ArrayList<>();
        long max=Long.MIN_VALUE;
        for(int num:nums){
            max=Math.max(num,max);
        }
        long ms=1;
        int idx=0;
        
        for(int i=0;i<n;i++){
            if(nums[i]==0)continue;
            if(nums[i]>0){
                ms*=nums[i];
            }

            else {
                
                neg.add(nums[i]);
            }
        }
        Collections.sort(neg);
        int j=0;
        int len=neg.size();
        int lidx=len;
        if(len%2!=0){
            lidx=len-2;
        }
        else{
            lidx=len-1;
        }
        while(j<=lidx){
            ms*=Math.abs(neg.get(j));
            j++;
        }
        max=Math.abs(max);
        
        if(ms==1&&neg.size()<=1){
            return max;
        }

        return ms;

    }
}