class Solution {
    int mod = 1000000007;
    public int numberOfGoodSubarraySplits(int[] nums) {
       int n=nums.length;
       List<Integer>list=new ArrayList<>();
       
       for(int i=0;i<n;i++){
         if(nums[i]==1){
            list.add(i);
         }
       }
       int count=1;
       if(list.size()==0)return 0;
       for(int i=1;i<list.size();i++){
          
             int elem=list.get(i)-list.get(i-1);
             count=(int)(((long)count*elem)%mod);
       }
       return count;
    }
}