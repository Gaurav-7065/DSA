class Solution {
    class Pair{
        char ch;
        int cnt;
        Pair(char ch,int cnt){
            this.ch=ch;
            this.cnt=cnt;
        }
    }
    public String removeDuplicates(String s, int k) {
   
    
      Stack<Pair>st=new Stack<>();
      
      for(int i=s.length()-1;i>=0;i--){
        char ch=s.charAt(i);
           if(!st.isEmpty()&&st.peek().ch==ch){
              st.peek().cnt++;
           }
           else{
            st.push(new Pair(ch,1));
           }

           if(st.peek().cnt==k){
             st.pop();
           }
         }

          StringBuilder sb=new StringBuilder();
      for(Pair p:st){
        for(int i=0;i<p.cnt;i++){
            sb.append(p.ch);
        }
      }
      return sb.reverse().toString();
    }
     
     
}