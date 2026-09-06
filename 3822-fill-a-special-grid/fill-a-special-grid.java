class Solution {

    public int[][] specialGrid(int n) {

        int size = 1 << n;
        int[][] ans = new int[size][size];

        fill(ans, 0, 0, n, 0);

        return ans;
    }

    private void fill(int[][] ans, int row, int col,
                      int n, int start) {

        // 1 × 1 grid
        if (n == 0) {
            ans[row][col] = start;
            return;
        }

        int size = 1 << n;
        int half = size / 2;

        // Number of elements in one quadrant
        int block = half * half;

        // Top-right → smallest
        fill(ans, row, col + half,
             n - 1, start);

        // Bottom-right
        fill(ans, row + half, col + half,
             n - 1, start + block);

        // Bottom-left
        fill(ans, row + half, col,
             n - 1, start + 2 * block);

        // Top-left → largest
        fill(ans, row, col,
             n - 1, start + 3 * block);
    }
}