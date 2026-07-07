class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String>list=new ArrayList<>();
        int m=dictionary.length;
        int n=queries.length;
        for(int i=0;i<n;i++){
            String word1=queries[i];
            for(int j=0;j<m;j++){
              String word2=dictionary[j];
              int count=0;
              for(int k=0;k<word2.length();k++){
                if(word1.charAt(k)!=word2.charAt(k)) count++;
              }
              if(count<=2){
                list.add(word1);
                break;
              }
            }
        }
        return list;
    }
}