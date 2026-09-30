class Solution {

    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public long maxScore(int[] nums) {

        int n = nums.length;

        long[] prefixGcd = new long[n];
        long[] suffixGcd = new long[n];

        long[] prefixLcm = new long[n];
        long[] suffixLcm = new long[n];
        if(n==0) return 0;
        if(n==1) return (long)(nums[0]*nums[0]);

        // Prefix GCD and LCM
        prefixGcd[0] = nums[0];
        prefixLcm[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixGcd[i] = gcd(prefixGcd[i - 1], nums[i]);
            prefixLcm[i] = lcm(prefixLcm[i - 1], nums[i]);
        }

        // Suffix GCD and LCM
        suffixGcd[n - 1] = nums[n - 1];
        suffixLcm[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixGcd[i] = gcd(nums[i], suffixGcd[i + 1]);
            suffixLcm[i] = lcm(nums[i], suffixLcm[i + 1]);
        }

        // At most one removal:
        // First consider removing nothing
        long ans = prefixGcd[n - 1] * prefixLcm[n - 1];
        
        // Try removing every element
        for (int i = 0; i < n; i++) {

            long g;
            long l;

            if (i == 0) {
                // Remove first element
                g = suffixGcd[1];
                l = suffixLcm[1];

            } else if (i == n - 1) {
                // Remove last element
                g = prefixGcd[n - 2];
                l = prefixLcm[n - 2];

            } else {
                // Combine left and right parts
                g = gcd(prefixGcd[i - 1], suffixGcd[i + 1]);
                l = lcm(prefixLcm[i - 1], suffixLcm[i + 1]);
            }

            ans = Math.max(ans, g * l);
        }

        return ans;
    }
}