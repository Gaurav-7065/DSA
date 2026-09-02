class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        int m=operations.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<m;i++){
            int u=operations[i][0];
            int v=operations[i][1];
            if(map.containsKey(u)&&!map.containsKey(v)){
                int idx=map.get(u);
                nums[idx]=v;
                map.put(v,idx);
                map.remove(u);
            }
        }
        return nums;
    }
}