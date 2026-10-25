class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();
        int i=0;
        int j=0;
       
        int cnt=0;
        while(i<m&&j<n){
            char ch1=s.charAt(j);
            char ch2=t.charAt(i);
            if(ch1==ch2){
                j++;
            }
            i++;
        }
        if(j<n)return false;
        else return true;
    }
}