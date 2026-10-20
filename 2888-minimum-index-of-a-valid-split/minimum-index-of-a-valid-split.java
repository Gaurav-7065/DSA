class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.size();
        for(int i=0;i<n;i++){
            int elm=nums.get(i);
            map.put(elm,map.getOrDefault(elm,0)+1);
        }
        int dominent=0;
        for(int val:map.keySet()){
           int m=map.get(val);
           if(m>n/2){
            dominent=val;
           }
        }
        int cntd=map.get(dominent);
        int cnt=0;
        for(int i=0;i<n-1;i++){
            if(nums.get(i)==dominent)cnt++;
            int x=cnt*2;
            boolean split1=false;
            if(x>i+1){
                split1=true;
            }
            boolean split2=false;
            int y=(cntd-cnt)*2;
            if(y>n-i-1){
                split2=true;
            }
            if(split1&split2){
                return i;
            }

        }
        return -1;
    }
}