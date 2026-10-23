class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        if(n==0) return 0;
        for(int x=0;x<k;x++){
            for(int y=0;y<k;y++){
                if(x==y)continue;

                // traverse through every nums and check for that is Valid of changing
                
                int cnt=0;
                for(int i=0;i<n;i++){
                    int current=nums[i]%k;
                    int target=i%2==0?x:y;
                    int diff=Math.abs(current-target);
                    cnt+=Math.min(diff,k-diff);
                }
                ans=Math.min(ans,cnt);
            }
        }
        return ans;
    }
}