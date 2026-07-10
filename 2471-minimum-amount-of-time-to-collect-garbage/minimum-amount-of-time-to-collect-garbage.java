class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int p = 0, m = 0, g = 0;
        int n = garbage.length;

        // Count total garbage pieces
        for (int i = 0; i < n; i++) {
            String word = garbage[i];
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == 'M') m++;
                else if (word.charAt(j) == 'G') g++;
                else p++;
            }
        }

        int ans = 0;

        // Metal truck
        int M = 0;
        int metal = m;
        for (int i = 0; i < n; i++) {
            String word = garbage[i];

            if (metal > 0) {
                for (char ch : word.toCharArray()) {
                    if (ch == 'M') {
                        M++;
                        metal--;
                    }
                }

                if (metal > 0 && i < travel.length) {
                    M += travel[i];
                }
            }
        }

        // Paper truck
        int P = 0;
        int paper = p;
        for (int i = 0; i < n; i++) {
            String word = garbage[i];

            if (paper > 0) {
                for (char ch : word.toCharArray()) {
                    if (ch == 'P') {
                        P++;
                        paper--;
                    }
                }

                if (paper > 0 && i < travel.length) {
                    P += travel[i];
                }
            }
        }

        // Glass truck
        int G = 0;
        int glass = g;
        for (int i = 0; i < n; i++) {
            String word = garbage[i];

            if (glass > 0) {
                for (char ch : word.toCharArray()) {
                    if (ch == 'G') {
                        G++;
                        glass--;
                    }
                }

                if (glass > 0 && i < travel.length) {
                    G += travel[i];
                }
            }
        }

        ans = M + P + G;
        return ans;
    }
}