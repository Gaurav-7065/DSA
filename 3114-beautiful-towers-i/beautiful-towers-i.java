class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n=heights.length;
        long ans=0;
        for(int i=0;i<n;i++){
            int peak=i;
            long maxSum=heights[peak];
            // left check
            long minl=heights[peak];
            for(int j=peak-1;j>=0;j--){
                 minl=Math.min(minl,heights[j]);
                 if(heights[j]<=minl){
                   maxSum+=heights[j];
                 }
                 else{
                    maxSum+=minl;
                 }
                 
               }
            
            // right check
            long minr=heights[peak];
            for(int j=peak+1;j<n;j++){
                minr=Math.min(minr,heights[j]);
                if(heights[j]<=minr){
                    maxSum+=heights[j];
                }
                else{
                    maxSum+=minr;
                }
            }
            ans=Math.max(maxSum,ans);
        }
        return ans;
    }
}