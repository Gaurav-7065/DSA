class Solution {
    public long calculateScore(String s) {
        int n=s.length();
        HashMap<Character,Stack<Integer>>map=new HashMap<>();
        long score=0;
        for(char ch='a';ch<='z';ch++){
            map.put(ch,new Stack<>());
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            char mirror = (char)('a' + ('z' - ch));
            if(!(map.get(mirror).isEmpty())){
              int idx=map.get(mirror).pop();
              score+=(i-idx);
            }
            else{
                map.get(ch).push(i);
            }

            
            

        }
        return score;
    }
}