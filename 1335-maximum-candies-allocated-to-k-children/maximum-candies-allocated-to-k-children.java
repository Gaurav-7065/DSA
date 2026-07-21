class Solution {
    public long helper(int[]candies,long candie){
        long cnt=0;
        for(int i=0;i<candies.length;i++){
            long x=(long)Math.floor(candies[i]/candie);
            cnt+=x;
        }
       return cnt;
    }
    public int maximumCandies(int[] candies, long k) {
        long sum=0;
        int min=Integer.MAX_VALUE;
        for(int num:candies){
            sum+=num;
            min=Math.min(min,num);
        }
        if(sum<k) return 0;

        int n=candies.length;
        long low=1;
        long high=sum;
        long ans=0;
        while(low<=high){
            long mid=(low+high)/2;
            long val=helper(candies,mid);
            if(val>=k){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return (int)ans;
    }
}