class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer>dq=new ArrayDeque<Integer>();
       int n=nums.length;
       int[]ans=new int[n-k+1];
       int idx=0;

       for(int i=0;i<n;i++){
         if(!dq.isEmpty()&&dq.getFirst()<=i-k)dq.pollFirst();
         while(!dq.isEmpty()&&nums[i]>=nums[dq.getLast()])dq.pollLast();
         dq.addLast(i);
         if(i>=k-1)ans[idx++]=nums[dq.getFirst()];
       }
       return ans;
    }
}