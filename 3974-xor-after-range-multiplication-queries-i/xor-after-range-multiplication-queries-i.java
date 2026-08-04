class Solution {
    int mod = 1000000007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        for (int[] q : queries) {
            int idx = q[0];
            int ri = q[1];
            int ki = q[2];
            int vi = q[3];

            while (idx <= ri) {
                nums[idx] = (int)(((long) nums[idx] * vi) % mod);
                idx += ki;
            }
        }

        int xor = nums[0];
        for (int i = 1; i < n; i++) {
            xor ^= nums[i];
        }

        return xor;
    }
}