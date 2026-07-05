class Solution {
    public int captureForts(int[] forts) {
        int n=forts.length;
        int ans=0;
        for(int i=n-1;i>=0;i--){
            int sum=forts[i];
            if(forts[i]==1||forts[i]==-1){
               
               for(int idx=i+1;idx<n;idx++){
                 if(forts[idx]!=0){
                     sum+=forts[idx];
                     if(sum==0){
                        ans=Math.max(Math.abs(i-idx)-1,ans);
                     }
                     break;
                 }
               }
            }
        }
        return ans;
    }
}