class Solution {
    public long minimumCost(int cost1, int cost2, int cost3, int need1, int need2) {

        // Case 1: Buy everything separately
        long separate = 1L * need1 * cost1 + 1L * need2 * cost2;

        // Case 2: Buy only Type-3 items
        long onlyBoth = 1L * Math.max(need1, need2) * cost3;

        // Case 3: Buy Type-3 for common needs, rest separately
        int common = Math.min(need1, need2);
        long mixed = 1L * common * cost3
                   + 1L * (need1 - common) * cost1
                   + 1L * (need2 - common) * cost2;

        return Math.min(separate, Math.min(onlyBoth, mixed));
    }
}