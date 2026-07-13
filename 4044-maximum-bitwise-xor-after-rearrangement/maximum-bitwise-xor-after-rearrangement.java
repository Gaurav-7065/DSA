class Solution {
    public String maximumXor(String s, String t) {
        StringBuilder sb=new StringBuilder();
        int one=0;
        int zero=0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='1')one++;
            else zero++;
           
        }
       for(int i=0;i<s.length();i++){
          int x=s.charAt(i)-'0';
          if(x==1){
            if(zero>0){
              sb.append(1);
              zero--;
            }
            else{
                sb.append("0");
                one--;
            }
          }
          else{
            if(one>0){
                sb.append("1");
                one--;
            }
            else{
                sb.append("0");
                zero--;
            }

          }

       }
       String ans=sb.toString();
        return ans;
    }
}