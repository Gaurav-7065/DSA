class Solution {
    public int countSpecialIntegers(int[] nums) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int count = 0;

        // Store indices for every number
        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }

            map.get(nums[i]).add(i);
        }

        // Check every number
        for (int key : map.keySet()) {

            ArrayList<Integer> indices = map.get(key);
            if(indices.size()<3) continue;

            // Only one occurrence
            if (indices.size() ==1) {
                count++;
                continue;
            }

            int diff = indices.get(1) - indices.get(0);

            boolean check = true;

            for (int j = 2; j < indices.size(); j++) {

                if (diff != indices.get(j) - indices.get(j - 1)) {
                    check = false;
                    break;
                }
            }

            if (check) {
                count++;
            }
        }

        return count;
    }
}