class Solution {

    public long countOfSubstrings(String word, int k) {
        return atMost(word, k) - atMost(word, k - 1);
    }

    private long atMost(String word, int k) {

        if (k < 0) return 0;

        int n = word.length();

        int[] last = {-1, -1, -1, -1, -1};

        int left = 0;
        int consonants = 0;

        long ans = 0;

        for (int right = 0; right < n; right++) {

            char ch = word.charAt(right);

            int vowelIndex = getVowelIndex(ch);

            if (vowelIndex != -1) {
                last[vowelIndex] = right;
            } else {
                consonants++;
            }

            // Keep at most k consonants
            while (consonants > k) {
                char leftChar = word.charAt(left);

                if (getVowelIndex(leftChar) == -1) {
                    consonants--;
                }

                left++;
            }

            // Check whether all 5 vowels have appeared
            int minLast = Integer.MAX_VALUE;

            for (int i = 0; i < 5; i++) {
                if (last[i] == -1) {
                    minLast = -1;
                    break;
                }

                minLast = Math.min(minLast, last[i]);
            }

            if (minLast >= left) {
                ans += minLast - left + 1;
            }
        }

        return ans;
    }

    private int getVowelIndex(char ch) {

        if (ch == 'a') return 0;
        if (ch == 'e') return 1;
        if (ch == 'i') return 2;
        if (ch == 'o') return 3;
        if (ch == 'u') return 4;

        return -1;
    }
}