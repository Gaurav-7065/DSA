class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        int ans = -1;
        HashSet<Long>set=new HashSet<>();
        for(int num:nums){
            set.add((long)(num));
        }
        for(int num:nums){
            long current=num;
            int cnt=1;
            while(set.contains(current*current)){
                current=current*current;
                cnt++;
            }
            if(cnt>=2){
                ans=Math.max(ans,cnt);
            }
        }
        return ans;
    }

    
}