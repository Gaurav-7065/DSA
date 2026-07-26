class Solution {
    private int helper(int m,int n,int k){
        int cnt=0;
        for(int i=1;i<=m;i++){
           int x=k/i;
           cnt+=Math.min(x,n);
        }
        return cnt;
    }
    public int findKthNumber(int m, int n, int k) {
         int low=1;
         int high=m*n;
         int ans=0;
         while(low<=high){
            int mid=(low+high)/2;
            int val=helper(m,n,mid);

            if(val>=k){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
         }
         return ans;
    }
}