class Solution {
    
    public int countArrays(int[] original, int[][] bounds) {
       int low=Integer.MIN_VALUE;
       int high=Integer.MAX_VALUE;
       int n=original.length;
       for(int i=0;i<n;i++){
          low=Math.max(low,bounds[i][0]-original[i]);
          high=Math.min(high,bounds[i][1]-original[i]);
       }
       if(low>high)return 0;
       return high-low+1;
    }
}