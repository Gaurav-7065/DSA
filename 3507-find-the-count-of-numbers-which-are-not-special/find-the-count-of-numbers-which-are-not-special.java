class Solution {
    public int nonSpecialCount(int l, int r) {
        int left=(int)Math.sqrt(l);
        int right=(int)Math.sqrt(r);
        int count=0;
        for(int i=left;i<=right;i++){
           if(isPrime(i)){
             if(i*i>=l&&i*i<=r) count++;
           }
        }
        int range=r-l+1;
        int ans=range-count;
        return ans;
    }
    public boolean isPrime(int n){
        if(n<2)return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
}