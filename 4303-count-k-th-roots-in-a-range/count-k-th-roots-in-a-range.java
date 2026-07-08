class Solution {
    public int countKthRoots(int l, int r, int k) {
        int count=0;
        if(k==1){
            return r-l+1;
        }
       
        int max=(int)Math.pow(r,1.0/k)+1;
       for(int i=0;i<=max;i++){
        long x=Math.round(Math.pow(i,k));

        if(l<=x&&x<=r) count++;
         
       }
       return count;
    }
}