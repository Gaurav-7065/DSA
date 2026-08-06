class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        int half = k / 2;

        // Original profit
        long originalProfit = 0;
        for (int i = 0; i < n; i++) {
            originalProfit += 1L * strategy[i] * prices[i];
        }

        long holdSum = 0;
        long sellSum = 0;

        // First window
        for (int i = 0; i < half; i++) {
            holdSum += -1L * strategy[i] * prices[i];
        }

        for (int i = half; i < k; i++) {
            sellSum += 1L * prices[i] - 1L * strategy[i] * prices[i];
        }

        long maxGain = Math.max(0, holdSum + sellSum);

        // Slide the window
        for (int start = 1; start <= n - k; start++) {

            // Update first half
            holdSum -= -1L * strategy[start - 1] * prices[start - 1];
            holdSum += -1L * strategy[start + half - 1] * prices[start + half - 1];

            // Update second half
            sellSum -= 1L * prices[start + half - 1]
                    - 1L * strategy[start + half - 1] * prices[start + half - 1];
            sellSum += 1L * prices[start + k - 1]
                    - 1L * strategy[start + k - 1] * prices[start + k - 1];

            maxGain = Math.max(maxGain, holdSum + sellSum);
        }

        return originalProfit + maxGain;
    }
}