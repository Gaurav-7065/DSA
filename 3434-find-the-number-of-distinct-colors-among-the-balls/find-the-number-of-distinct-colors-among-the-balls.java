class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer>bulb=new HashMap<>();
        HashMap<Integer,Integer>freq=new HashMap<>();
        int n=queries.length;
        int colors=0;
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            int b=queries[i][0];
            int c=queries[i][1];
            if(bulb.containsKey(b)){
                int oldColor=bulb.get(b);

                freq.put(oldColor,freq.get(oldColor)-1);
                if(freq.get(oldColor)==0){
                    colors--;
                }
                freq.put(c,freq.getOrDefault(c,0)+1);
                if(freq.get(c)==1)colors++;
                bulb.put(b,c);
            }
            else{
                bulb.put(b,c);
                freq.put(c,freq.getOrDefault(c,0)+1);
                if(freq.get(c)==1){
                    colors++;
                }
            }
            ans[i]=colors;
        }
        return ans;
    }
}