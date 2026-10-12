class Solution {
    public int minimumLevels(int[] possible) {
      int n=possible.length;
    
      int sum=0;
      for(int num:possible){
        sum+=(num==1)?1:-1;
      }
      
      int prefix=0;
      int ans=0;
      int profit=Integer.MIN_VALUE;
      for(int i=0;i<n-1;i++){
         prefix+=(possible[i]==1)?1:-1;
         if(prefix>sum-prefix){
            return i+1;
            
         }
      }
      return -1;
    }
}