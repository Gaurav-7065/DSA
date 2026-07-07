class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        // merge
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(new int[] { intervals[0][0], intervals[0][1] });
        int N = intervals.length;
      
        for (int i = 1; i < N; i++) {
            int end = list.get(list.size() - 1)[1];

            if (intervals[i][0] <= end) {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            } else {
                list.add(new int[] { intervals[i][0], intervals[i][1] });
            }
        }

        long bulbneed = (brightness + 2L) / 3;
        long ans = 0;
        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i)[0];
            int end = list.get(i)[1];

            long range = (long) (end - start + 1);
            ans += (range * bulbneed);

        }

        return ans;

    }
}