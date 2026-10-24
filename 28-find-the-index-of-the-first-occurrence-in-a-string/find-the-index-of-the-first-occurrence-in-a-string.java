class Solution {
    public int strStr(String hs, String nd) {
        int n1=hs.length();
        int n2=nd.length();
        int idx=-1;
        for(int i=0;i<=n1-n2;i++){
            if(hs.charAt(i)==nd.charAt(0)){
                String substr=hs.substring(i,i+n2);
                if(substr.equals(nd)){
                    return i;
                }
            }  
        }
        return -1;
    }
}