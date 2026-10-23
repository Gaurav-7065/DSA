class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int n=s.length();
        int i=0;
        int j=0;
        int cnt=0;
        if(n==1)return 1;
        int maxi=Integer.MIN_VALUE;
        while(j<n-1){
            
            if(s.charAt(j)==s.charAt(j+1)){
                cnt++;
            }
            while(cnt>1){
                if(i<n-1&&s.charAt(i)==s.charAt(i+1)){
                    cnt--;
                }
                i++;
            }
            j++;
            maxi=Math.max(maxi,j-i+1);
        }
        return maxi;
    }
}