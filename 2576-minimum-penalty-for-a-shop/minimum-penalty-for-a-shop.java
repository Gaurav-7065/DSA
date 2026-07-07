class Solution {
    public int bestClosingTime(String cust) {
        int n=cust.length();
        int Y=0;
        int N=0;
        int min=Integer.MAX_VALUE;
        int idx=0;
        for(int i=0;i<n;i++){
            if(cust.charAt(i)=='Y'){
                Y++;
            }
        }
        if(Y==n) return n;
        if(Y==0) return 0;

        for(int i=0;i<n;i++){
            int penaltY=Y+N;
            if(penaltY<min){
                min=penaltY;
                idx=i;
            }
            if(cust.charAt(i)=='Y'){
                Y--;
            }
            else if(cust.charAt(i)=='N'){
                N++;
            }
        }
        int penalty=Y+N;
        if(penalty<min){
            idx=n;
        }
        return  idx;
    }
}