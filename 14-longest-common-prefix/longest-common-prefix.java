class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        String s=strs[0];
        for(int i=0;i<n;i++){
            s=helper(s,strs[i]);
        }
        return s;
    }
    public String helper(String s1,String s2){
        StringBuilder sb=new StringBuilder();
        int n=s1.length()>s2.length()?s2.length():s1.length();
        
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
               return sb.toString();
            }
            sb.append(s1.charAt(i));
        }
        return sb.toString();
    }
}