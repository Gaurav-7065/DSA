class Solution {
    public int maxOperations(String s) {
        int count=0;
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1')count++;
            else{
                if(i>0&&s.charAt(i)==s.charAt(i-1))continue;
                ans+=count;
            }
        }
        return ans;
    }
}