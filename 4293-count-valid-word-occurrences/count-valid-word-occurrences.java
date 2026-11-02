class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
       int n=chunks.length;
       int m=queries.length;

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++){
            sb.append(chunks[i]);
        }

        String s=sb.toString();
        

        HashMap<String,Integer>map=new HashMap<>();
        StringBuilder word=new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            boolean valid = ch >= 'a' && ch <= 'z';

            if (ch == '-' && i > 0 && i < s.length() - 1) {
                valid = s.charAt(i - 1) >= 'a' && s.charAt(i - 1) <= 'z'
                     && s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z';
            }

            if (valid) {
                word.append(ch);
            } else {
                if (word.length() > 0) {
                    String str = word.toString();
                    map.put(str, map.getOrDefault(str, 0) + 1);
                    word.setLength(0);
                }
            }
        }

        // Handle the last word
        if (word.length() > 0) {
            String str = word.toString();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            ans[i] = map.getOrDefault(queries[i], 0);
        }

        return ans;
    

    }
}