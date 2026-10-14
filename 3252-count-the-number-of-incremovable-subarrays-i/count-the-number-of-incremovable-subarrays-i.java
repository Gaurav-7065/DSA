class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                boolean check=isStrict(nums,i,j);
                if(check){
                   count++;
                }
            }
        }
        return count;
    }
    public boolean isStrict(int[]nums,int l,int r){
        boolean flag=true;
        int prev=-1;
        for(int i=0;i<nums.length;i++){
            if(i>=l&&i<=r)continue;
              
                if(prev!=-1&&nums[i]<=prev){
                    flag=false;
                    return flag;
                }
                prev=nums[i];
        }
        return flag;
    }
}