class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>>list=new ArrayList<>();
        for(int i=1;i<=n/2;i++){
           if(isPrime(i)&&isPrime(n-i)){
            
            list.add(new ArrayList<>());
            list.get(list.size()-1).add(i);
            list.get(list.size()-1).add(n-i);
            
           }
        }
        return list;
    }
    boolean isPrime(int elem){
        if(elem==2)return true;
        if(elem<2||elem%2==0)return false;
        
        
        for(int i=3;i*i<=elem;i+=2){
            if(elem%i==0){
              return false;
            }
        }
        return true;
    }
}