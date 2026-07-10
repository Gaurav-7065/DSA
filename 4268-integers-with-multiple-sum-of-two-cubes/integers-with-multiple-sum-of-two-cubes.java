class Solution {
    public List<Integer> findGoodIntegers(int n) {
        HashMap<Long,Integer>map=new HashMap<>();
        for(int a=0;a*a*a<=n;a++){
            for(int b=0;b*b*b+a*a*a<=n;b++){
                long sum=b*b*b+a*a*a;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        List<Integer>list=new ArrayList<>();
        for(long v:map.keySet()){
            if(map.get(v)>2){
                list.add((int)v);
            }
        }
        Collections.sort(list);
        return list;
    }
}