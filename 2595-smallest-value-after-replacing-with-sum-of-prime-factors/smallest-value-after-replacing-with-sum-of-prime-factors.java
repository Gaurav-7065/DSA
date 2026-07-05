class Solution {
    public int smallestValue(int n) {
        int x=n;
       
        while(n>5&&!isPrime(n)){
            int sum=0;
            for(int i=2;i*i<=n;i++){
                while(n%i==0){
                    sum+=i;
                    n/=i;
                }
            }
            if(n>1){
                sum+=n;
            }
            n=sum;
        }
        return n;
    }
    private boolean isPrime(int n){
        boolean isPrime=true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                isPrime=false;
                return isPrime;
                
            }
        }
        return isPrime;
    }
}