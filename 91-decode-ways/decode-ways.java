class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(s,0,dp);
    }
    public int dfs(String s,int idx,int[]dp){
        if(idx>s.length()-1){
            return 1;
        }
        if(s.charAt(idx)=='0'){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int ways=dfs(s,idx+1,dp);

        if(idx+1<s.length()){
            String str=s.substring(idx,idx+2);
            int num=Integer.parseInt(str);
            if(num>=10&&num<=26){
                ways+=dfs(s,idx+2,dp);
            }
        }
        dp[idx]=ways;
        return dp[idx];
    }
}