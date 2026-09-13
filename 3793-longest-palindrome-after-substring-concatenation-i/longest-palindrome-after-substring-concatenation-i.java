class Solution {
    public int longestPalindrome(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int maxLen = 1;
  
        for (int i = 0; i < n1; i++) {
            for (int j = i; j <= n1; j++) {
                String substr1 = s.substring(i, j);

                for (int l = 0; l < n2; l++) {
                    for (int m = l; m <= n2; m++) {
                        String substr2 = t.substring(l, m);
                        String str = substr1 + substr2;

                        if (str.length() > maxLen && palindrome(str)) {
                            maxLen = Math.max(maxLen, str.length());
                        }
                    }
                }
            }
        }
        return maxLen;

    }

    boolean palindrome(String str) {
        int n = str.length();
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}