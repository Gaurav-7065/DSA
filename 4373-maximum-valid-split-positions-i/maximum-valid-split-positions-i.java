class Solution {
    public int maxValidSplits(int[] nums) {
        int n=nums.length;
        int x=noremove(nums);
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            nums[i]=0;
            int y=noremove(nums);
            nums[i]=temp;
            max=Math.max(max,y);
        }
        int ans=Math.max(x,max);
        return ans;

    }
    public int noremove(int[]nums){
        int count=0;
        int[]prefixGcd=new int[nums.length];
        int[]suffixGcd=new int[nums.length];
        prefixGcd[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefixGcd[i]=gcd(prefixGcd[i-1],nums[i]);
        }
        suffixGcd[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suffixGcd[i]=gcd(suffixGcd[i+1],nums[i]);
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0)continue;
            int gcdl=prefixGcd[i];
            int gcdr=suffixGcd[i+1];
            
            if(gcdl==gcdr)count++;
        }
        return count;
    }
    int gcd(int a,int b){
        while(b!=0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        return a;
    }
}