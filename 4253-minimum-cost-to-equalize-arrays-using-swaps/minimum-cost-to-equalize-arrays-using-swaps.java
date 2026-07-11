class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cnt2 = new HashMap<>();

        // Count frequencies of nums2
        for (int x : nums2) {
            cnt2.put(x, cnt2.getOrDefault(x, 0) + 1);
        }

        Map<Integer, Integer> extra = new HashMap<>();

        // Cancel common occurrences
        for (int x : nums1) {
            if (cnt2.getOrDefault(x, 0) > 0) {
                cnt2.put(x, cnt2.get(x) - 1);
            } else {
                extra.put(x, extra.getOrDefault(x, 0) + 1);
            }
        }

        int ans = 0;

        // Check extras in nums1
        for (int freq : extra.values()) {
            if (freq%2!=0) return -1;
            ans += freq / 2;
        }

        // Check extras in nums2
        for (int freq : cnt2.values()) {
            if (freq%2!=0) return -1;
        }

        return ans;
    }
}