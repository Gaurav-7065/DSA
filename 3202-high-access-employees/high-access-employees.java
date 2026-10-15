class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> at) {
        HashMap<String,List<Integer>>map=new HashMap<>();
        int n=at.size();
       
        for(int i=0;i<n;i++){
            String str=at.get(i).get(0);
            String st=at.get(i).get(1);
            int time=Integer.parseInt(st);
            int min=(time/100)*60+(time%100);
            map.putIfAbsent(str,new ArrayList<>());
            map.get(str).add(min);
        }
        List<String>ans=new ArrayList<>();
        for(String name:map.keySet()){
            List<Integer>times=map.get(name);
            Collections.sort(times);
            
            for(int i=0;i+2<times.size();i++){
                if(times.get(i+2)-times.get(i)<60){
                    ans.add(name);
                    break;
                }
            }
            
        }
        
        return ans;
    }
}