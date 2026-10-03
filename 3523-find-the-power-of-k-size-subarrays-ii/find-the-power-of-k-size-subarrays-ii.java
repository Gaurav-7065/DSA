class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Arrays.fill(res, -1);
        int l = 0;
        int consecutive = 1;
        if(k==1) return nums;
        
        for (int r = 1; r < n; r++) {
            if (nums[r-1]+1== nums[r]) {
                consecutive++;
            } else {
                consecutive = 1;
            }
            if (r - l + 1 == k) {
                if (consecutive == k) {
                    res[l] = nums[r];
                    consecutive--;            
                }
                l++;
                
            }
            

        }
        return res;
    }
}