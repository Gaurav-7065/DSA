class Solution {
    public void nextPermutation(int[] nums) {
        int gola_idx = -1;
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                gola_idx = i - 1;
                break;
            }
        }
        int target_idx = -1;
        if (gola_idx != -1) {
            for (int j = n - 1; j >= gola_idx + 1; j--) {
                if (nums[j] > nums[gola_idx]) {
                    target_idx = j;
                    break;
                }
            }

            // swap gola_idx and target_idx
            int temp = nums[gola_idx];
            nums[gola_idx] = nums[target_idx];
            nums[target_idx] = temp;
        }
        int i = gola_idx + 1;
        int j = n - 1;
        while (i <= j) {
            int temp1 = nums[i];
            nums[i] = nums[j];
            nums[j] = temp1;
            i++;
            j--;
        }

    }
}