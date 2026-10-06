class Solution {
    String str = "";
    List<String> ans = new ArrayList<>();

    public List<String> generateValidStrings(int n, int k) {
        helper(n, k, 0, 0);
        return ans;
    }

    public void helper(int n, int k, int paas, int cost) {

        if (str.length() == n) {
            if (cost <= k) {
                ans.add(str);
            }
            return;
        }

        // Choose 0
        str += "0";
        helper(n, k, 0, cost);
        str = str.substring(0, str.length() - 1);

        // Choose 1 only if previous was 0
        if (paas == 0) {

            int index = str.length();

            str += "1";

            cost += index;

            helper(n, k, 1, cost);

            cost -= index;

            str = str.substring(0, str.length() - 1);
        }
    }
}