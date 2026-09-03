class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int idx=0;
        int count=1;
        for(int i=0;i<nums.length;i++){
          if(nums[i]-nums[idx]>k){
            idx=i;
            count++;
          }
        }
        return count;
    }
}