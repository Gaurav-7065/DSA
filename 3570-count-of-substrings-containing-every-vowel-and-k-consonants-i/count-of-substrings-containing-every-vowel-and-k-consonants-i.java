class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int count = 0;

        for (int i = 0; i < n - 4; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substr = word.substring(i, j);

                if (valid(substr, k)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean valid(String str, int k) {
        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int idx = ch - 'a';
            freq[idx]++;
        }

        // Check all 5 vowels are present
        if (freq['a' - 'a'] == 0 ||
            freq['e' - 'a'] == 0 ||
            freq['i' - 'a'] == 0 ||
            freq['o' - 'a'] == 0 ||
            freq['u' - 'a'] == 0) {
            return false;
        }

        // Count consonants
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                continue;
            }

            k--;
        }

        return k == 0;
    }
}