class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>resultlist=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        backtrack(nums,resultlist,list);
        return resultlist;
    }
    void backtrack(int[]nums,List<List<Integer>>resultlist,List<Integer>list){
        if(list.size()==nums.length){
            resultlist.add(new ArrayList<>(list));
            return;
        }
        for(int num:nums){
            if(list.contains(num))continue;
            list.add(num);
            backtrack(nums,resultlist,list);
            list.remove(list.size()-1);
        }
    }
}