class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        long cn10=0;
        long ms1=0;
        for(int i=0;i<n1;i++){
            if(nums1[i]==0)cn10++;
           if(nums1[i]==0)ms1+=1;
           else{
             ms1+=nums1[i];
           }
           
        }
        long cn20=0;
        long ms2=0;
        for(int i=0;i<n2;i++){
            if(nums2[i]==0)cn20++;
            if(nums2[i]==0)ms2+=1;
            else{
              ms2+=nums2[i];
            }
            
        }
        if(ms1==ms2){
            return ms1;
        }
        else if(ms1<ms2){
            if(cn10==0)return -1;
            return ms2;
        }
        else {
            if(cn20==0)return -1;
            return ms1;
        }
        
    }
    
}