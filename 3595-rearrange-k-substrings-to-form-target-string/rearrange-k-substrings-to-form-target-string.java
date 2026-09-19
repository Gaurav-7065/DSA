class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        HashMap<String,Integer>map1=new HashMap<>();
        HashMap<String,Integer>map2=new HashMap<>();
        int n=s.length();
        int div=n/k;
        int idx=0;
        while(idx<=n-div){
            String str=s.substring(idx,idx+div);
            map1.put(str,map1.getOrDefault(str,0)+1);
            idx+=div;
        }

        int n2=t.length();
        int div2=n2/k;
        int idx2=0;
        while(idx2<=n2-div2){
            String str=t.substring(idx2,idx2+div2);
            map2.put(str,map2.getOrDefault(str,0)+1);
            idx2+=div2;
        }

       return map1.equals(map2);
    }
}