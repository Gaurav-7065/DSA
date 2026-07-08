class Solution {
    public String oddString(String[] words) {
        int n=words.length;
        HashMap<String,Integer>map=new HashMap<>();
        HashMap<String,String>patternMap=new HashMap<>();

        for(int i=0;i<n;i++){
            String word=words[i];
            StringBuilder sb=new StringBuilder();
            
            for(int j=0;j<word.length()-1;j++){
                int diff=word.charAt(j)-word.charAt(j+1);
                sb.append(diff).append(",");
            }
            String pattern=sb.toString();
            map.put(pattern,map.getOrDefault(pattern,0)+1);
            patternMap.put(pattern,word);
        }

        for(String pattern:map.keySet()){
            if(map.get(pattern)==1){
                return patternMap.get(pattern);
            }
        }

        return "";
    }
}