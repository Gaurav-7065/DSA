class Solution {
    int mod=1000000007;
    public long maximumPoints(int[] eE, int cE) {
        Arrays.sort(eE);
        int idx=0;
        int n=eE.length;
        int l=n-1;
        long points=0;
        if(eE[0]>cE)return points;
        while(l>=idx){
            
            if(cE>=eE[idx]){
                long count=cE/eE[idx];
                points+=count;
                cE%=eE[idx];
            }
            else if(points>0){
                cE=(cE+eE[l])%mod;
                l--;
            }
        }
        return points;
    }
}