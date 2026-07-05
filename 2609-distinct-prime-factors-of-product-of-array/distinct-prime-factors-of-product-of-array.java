class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            for(int j=2;j*j<=x;j++){
                while(x%j==0){
                    set.add(j);
                    x/=j;
                }

            }
            if(x>1) set.add(x);
        }
        return set.size();
    }
}