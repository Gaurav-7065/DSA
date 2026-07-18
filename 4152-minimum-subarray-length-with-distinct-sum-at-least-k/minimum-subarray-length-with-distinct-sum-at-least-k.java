class Solution {
    public int minLength(int[] nums, int k) {
        int n=nums.length;
        int low=0;
        int high=0;
        int sum=nums[high];
        int ans=Integer.MAX_VALUE;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(nums[high],1);
        while(high<n){
            
            while(sum>=k){
               ans=Math.min(ans,high-low+1);
               map.put(nums[low],map.get(nums[low])-1);
               if(map.get(nums[low])==0){
                sum-=nums[low];
                map.remove(nums[low]);
               }
               low++;
            }
            high++;
            if(high<n){
              map.put(nums[high],map.getOrDefault(nums[high],0)+1);
            }
            
            if(high<n && map.get(nums[high])==1){ 
              sum+=nums[high];
              
            }
  
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}