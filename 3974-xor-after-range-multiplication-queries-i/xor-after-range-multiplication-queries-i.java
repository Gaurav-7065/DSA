class Solution {
    int mod=1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        int m=queries.length;

        for(int i=0;i<m;i++){
            int idx=queries[i][0];
            int ri=queries[i][1];
            int vi=queries[i][3];
            int ki=queries[i][2];
            while(idx<=ri){
                nums[idx]=(int)(((long)nums[idx]*vi)%mod);
                idx+=ki;
            }
        }
        long xor=nums[0];
        for(int i=1;i<n;i++){
            xor=(xor^nums[i]);
        }
        return (int)xor;
    }
}