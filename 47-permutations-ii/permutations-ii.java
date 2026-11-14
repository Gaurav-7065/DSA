class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        boolean[]isUsed=new boolean[n];
        backtrack(nums,new ArrayList<>(),ans,isUsed);
        return ans;
    }
    public void backtrack(int[]nums,List<Integer>list,List<List<Integer>>ans,boolean[]isUsed){
        if(list.size()==nums.length){
           if(!ans.contains(list)){
              ans.add(new ArrayList(list));
           }
           return;
        }
        for(int i=0;i<nums.length;i++){
            if(isUsed[i])continue;
            
            isUsed[i]=true;
            list.add(nums[i]);
            backtrack(nums,list,ans,isUsed);
            list.remove(list.size()-1);
            isUsed[i]=false;

        }
    }
}