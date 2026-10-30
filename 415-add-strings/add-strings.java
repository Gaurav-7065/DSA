class Solution {
    public String addStrings(String num1, String num2) {
        int n1=num1.length();
        int n2=num2.length();
        int i=n1-1;
        int j=n2-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0||j>=0||carry!=0){
            int ch1=0;
            int ch2=0;
            if(i>=0){
              ch1=(int)num1.charAt(i)-'0';
              i--;
            }
            if(j>=0){
               ch2=(int)(num2.charAt(j))-'0';
               j--;
            }
            
            int sum=ch1+ch2+carry;
            sb.append(sum%10);
            carry=sum/10;
            

        }
        return sb.reverse().toString();
    }
}