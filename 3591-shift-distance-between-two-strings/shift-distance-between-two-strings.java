class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] prevCost) {
        long cost = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (ch1 == ch2)
                continue;

            long val1 = findCost(nextCost, prevCost, ch1, ch2, true);
            long val2 = findCost(nextCost, prevCost, ch1, ch2, false);
            cost += Math.min(val1, val2);
        }
        return cost;
    }

    public long findCost(int[] nextCost, int[] prevCost, char ch1, char ch2, boolean nextCosta) {

        long nCost = 0;
        long pCost = 0;
        if (nextCosta) {
            int start = ch1 - 'a';
            int end = ch2 - 'a';

            if (start <= end) {
                for (int i = start; i < end; i++) {
                    nCost += nextCost[i];
                }
            } else {
                for (int i = start; i < 26; i++) {
                    nCost += nextCost[i];
                }
                for (int i = 0; i < end; i++) {
                    nCost += nextCost[i];
                }
            }

            return nCost;
        } else {
            int start = ch1 - 'a';
            int end = ch2 - 'a';

            if (start >= end) {
                for (int i = start; i > end; i--) {
                    pCost += prevCost[i];
                }
            } else {
                for (int i = start; i >= 0; i--) {
                    pCost += prevCost[i];
                }

                for (int i = 25; i > end; i--) {
                    pCost += prevCost[i];
                }
            }
            return pCost;
        }

    }
}