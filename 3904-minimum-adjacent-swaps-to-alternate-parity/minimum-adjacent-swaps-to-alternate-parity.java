class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        ArrayList<Integer>even=new ArrayList<>();
        ArrayList<Integer>odd=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
               even.add(i);
            }
            else{
                odd.add(i);
            }
        }
        if(Math.abs(even.size()-odd.size())>1){
            return -1;
        }

        long ans=Long.MAX_VALUE;

        if(even.size()>=odd.size()){
            long swaps=0;
            for(int i=0;i<even.size();i++){
                swaps+=Math.abs(even.get(i)-2L*i);
            }
            ans=Math.min(swaps,ans);
        }

        if(odd.size()>=even.size()){
            long swaps=0;
            for(int i=0;i<odd.size();i++){
                swaps+=Math.abs(odd.get(i)-2L*i);
            }
            ans=Math.min(swaps,ans);
        }
        return (int)ans;
    }
}