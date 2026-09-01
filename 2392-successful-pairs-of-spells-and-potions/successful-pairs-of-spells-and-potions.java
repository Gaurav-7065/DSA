class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int ans[]=new int[n];
        int m=potions.length;
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            int l=0;int r=potions.length-1;
            long count=0;
            while(l<=r){
                int mid=(l+r)/2;
                long comp=(long)potions[mid]*spells[i];
                if(comp>=success){
                   count=(m-mid);
                   r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            ans[i]=(int)count;
        }
        return ans;
    }
}