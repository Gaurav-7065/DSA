class Solution {
    class Pair{
        String word;int steps;
        Pair(String word,int steps){
            this.word=word;this.steps=steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       HashSet<String>set=new HashSet<>();
       Queue<Pair>q=new LinkedList<>();
       
       for(int i=0;i<wordList.size();i++){
         set.add(wordList.get(i));
       }

       if(!set.contains(endWord)) return 0;
       q.add(new Pair(beginWord,1));
       set.remove(beginWord);

       while(!q.isEmpty()){
         Pair p=q.poll();
         String word=p.word;
         int step=p.steps;
         if(word.equals(endWord)) return step;

         for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char[]charArray=word.toCharArray();
                charArray[i]=ch;
                String newWord=new String(charArray);
                if(set.contains(newWord)){
                    set.remove(newWord);
                    q.add(new Pair(newWord,step+1));
                }
            }
         }
       }
       return 0;
    }
}
