class Solution {
    public int helper(int[]citations,int papers){

        int cnt=0;
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=papers){
                cnt++;
            }
        }
        return cnt;

    }
    public int hIndex(int[] citations) {
        int n=citations.length;
        int low=1;
        int high=n;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int ncitations=helper(citations,mid);
            if(ncitations>=mid){
              ans=mid;
              low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return ans;
        
    }

}