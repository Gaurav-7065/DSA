class Solution {
    public String getSmallestString(String s, int k) {
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        int d=0;
        if(k==0)return s;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a')continue;
            char c=s.charAt(i);
            if(d>k)break;
            for(char ch='a';ch<='z';ch++){
               int dist=Math.min(Math.abs(c-ch),26-Math.abs(c-ch));
               if(d+dist<=k){
                  d=d+dist;
                  sb.setCharAt(i,ch);
                  break;
               }
               
            }
        }
        return sb.toString();
    }
}