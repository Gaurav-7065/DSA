class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        long cost1=0;
        long cost2=k;
        int n=arr.length;
        for(int i=0;i<n;i++){
            cost1+=Math.abs(arr[i]-brr[i]);
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        for(int i=0;i<n;i++){
            cost2+=Math.abs(arr[i]-brr[i]);
        }
        return Math.min(cost1,cost2);
    }
}