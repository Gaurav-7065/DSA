class Solution {
    public long minArraySum(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        long sum=0;
        for(int i=0;i<n;i++){
            int val=find(nums[i],set);
            sum+=val;
        }

        return sum;
    }
    public int find(int elem,HashSet<Integer>set){
           
           int best=elem;
           for(int i=1;i*i<=elem;i++){
               if(elem%i==0){
                 if(set.contains(i)){
                    best=Math.min(best,i);
                 }
                 int other=elem/i;
                 if(set.contains(other)){
                    best=Math.min(best,other);
                 }
               }
           }
           return best;
    }
}