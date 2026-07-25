class Solution {
    public long maxProduct(int[] nums) {
        int n=nums.length;
      
        long fh=Integer.MIN_VALUE,sh=2;

        for(int i=0; i<=n-1; i++){
            int el=Math.abs(nums[i]);
            if(el>fh){
                sh=fh;
                fh=el;
            }
            else{
                if(el>sh){
                    sh=el;
                }
            }
        }
        long ans=fh*sh*100000;
        return ans;
    }
}