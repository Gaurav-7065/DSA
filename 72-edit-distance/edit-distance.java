class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[]prev=new int[m+1];
        int[]curr=new int[m+1];
        
        for(int i=0;i<=m;i++){
            prev[i]=i;
        }
        
        for(int i=1;i<=n;i++){
            curr[0]=i;
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    curr[j]=prev[j-1];
                }
                else{
                    int x=1+prev[j];
                    int y=1+curr[j-1];
                    int z=1+prev[j-1];
                    curr[j]=Math.min(x,Math.min(y,z));
                }
            }
            int[]temp=prev;
            prev=curr;
            curr=temp;
        }
        return  prev[m];
    }
    // public int helper(String s,String t,int i,int j,int[][]dp){
    //     if(i<0){
    //         return j+1;
    //     }
    //     if(j<0){
    //         return i+1;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     if(s.charAt(i)==t.charAt(j)){
    //         return dp[i][j]=helper(s,t,i-1,j-1,dp);
    //     }
    //     else{
    //         int insert=1+helper(s,t,i,j-1,dp);
    //         int delete=1+helper(s,t,i-1,j,dp);
    //         int replace=1+helper(s,t,i-1,j-1,dp);
    //         return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    //     }
    //  }
}