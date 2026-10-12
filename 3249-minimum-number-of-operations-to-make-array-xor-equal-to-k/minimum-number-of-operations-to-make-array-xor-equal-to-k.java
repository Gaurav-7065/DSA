class Solution {
    public int minOperations(int[] nums, int k) {
        int xor=0;
        for(int num:nums){
            xor=xor^num;
        }
        int ans=Integer.bitCount(xor^k);
        return ans;
    }
}