class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        boolean odd=false;
        int cnt=0;
        for(int val:map.values()){
            
            if(val%2==0){
               cnt+=val;
            }
            else{
                cnt+=val-1;
                odd=true;
            }
            
        }
       return odd==true?cnt+1:cnt;
    }
}