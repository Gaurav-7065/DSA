class Solution {
    public int minNumberOfHours(int iEng, int iExp, int[] energy, int[] experience) {
        int n=energy.length;
        int ans=0;
        for(int i=0;i<n;i++){
             if(iEng<=energy[i]){
                int x=energy[i]-iEng+1;
                iEng+=x;
                ans+=x;
             }
             if(iExp<=experience[i]){
                int y=experience[i]-iExp+1;
                iExp+=y;
                ans+=y;
             }
             iEng-=energy[i];
             iExp+=experience[i];
            }
        
        return ans;
    }
}