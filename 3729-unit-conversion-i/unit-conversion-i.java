class Solution {
    int mod = 1000000007;

    public int[] baseUnitConversions(int[][] conversions) {

        int n = conversions.length + 1;

        // graph[source] = {target, factor}
        ArrayList<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] conversion : conversions) {
            int source = conversion[0];
            int target = conversion[1];
            int factor = conversion[2];

            graph[source].add(new int[]{target, factor});
        }

        int[] ans = new int[n];
        ans[0] = 1;

        dfs(0, graph, ans);

        return ans;
    }

    void dfs(int source, ArrayList<int[]>[] graph, int[] ans) {

        for (int[] edge : graph[source]) {

            int target = edge[0];
            int factor = edge[1];

            ans[target] = (int) ((long) ans[source] * factor % mod);

            dfs(target, graph, ans);
        }
    }
}