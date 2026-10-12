class Solution {
    public long flowerGame(int n, int m) {
        long En=n/2;
        long On=(n+1)/2;
        long Em=m/2;
        long Om=(m+1)/2;

        long ans=(En*Om)+(Em*On);
        return ans;
    }
}