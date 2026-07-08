class Solution {
    public int countTime(String time) {
        // hour check
        int cnt1=0;
        int id1=0;
        for(int i=1;i>=0;i--){
           if(time.charAt(i)=='?'){
             cnt1++;
             id1=i;
           }
        }
        int x=1;
        if(cnt1==2) x=24;
        else if(cnt1==1){
            if(id1==0){
                if(time.charAt(1)-'0'>3) x=2;
                else x=3;
            }
            else if(id1==1){
                if(time.charAt(0)=='2') x=4;
                else x=10;
            }
        }
        
        // for min
        int cnt2=0;
        int idx2=0;
        for(int i=4;i>=3;i--){
          if(time.charAt(i)=='?') {
            idx2=i;
            cnt2++;
          };
        }
        int y=1;
        if(cnt2==2) y=60;
        else if(cnt2==1){
            if(idx2==3) y=6;
            else y=10;
        }

        return x*y;
    }
}