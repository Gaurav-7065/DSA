class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n==1) return (long)s;
        long peak=(long)(n/2)*m;
        long valley=n/2-1;
        long maxVal=s+peak-valley;
        return maxVal;
    }
}