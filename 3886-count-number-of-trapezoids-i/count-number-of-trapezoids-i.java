class Solution {
    long MOD = 1000000007l;

    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] point : points) {
            int y = point[1];
            map.put(y, map.getOrDefault(y, 0) + 1);
        }
        long ans = 0;
        long sum = 0;
        for (int point : map.values()) {
            long pairs = (long) point * (point - 1) / 2;
            ans = (ans + sum * pairs) % MOD;
            sum = (sum + pairs) % MOD;
        }
        return (int) ans;
    }
}