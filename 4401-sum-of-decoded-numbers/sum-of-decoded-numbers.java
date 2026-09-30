class Solution {
    long mod=1000000007;
    public int sumDecoded(long[] nums) {
        int n=nums.length;
        long ans=0;
        for(int i=0;i<n;i++){
            long elem=nums[i];
            long w=elem%10;
            long d=(long)Math.floor(elem/10);
            
            long temp=d;
            int digits=0;
            while(temp>0){
                digits++;
                temp/=10;
            }
            long divisor=power(10,digits-w);
            long x=d/divisor;
            long y=d%divisor;
            long dValue=power(x,y);
            ans=(ans+dValue)%mod;
        }
        return (int)ans;
    }
    public long power(long x, long y) {

        long result = 1;

        x %= mod;

        while (y > 0) {

            if (y % 2 == 1) {
                result = (result * x) % mod;
            }

            x = (x * x) % mod;
            y /= 2;
        }

        return result;
    }
}