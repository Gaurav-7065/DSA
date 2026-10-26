class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>mp=new HashMap<>();
        int n=strs.length;
        for(int i=0;i<n;i++){
            String word=strs[i];
            char arr[]=word.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);

            if(!mp.containsKey(key)){
                mp.put(key,new ArrayList<>());
            }
            mp.get(key).add(word);
        }
        List<List<String>>ans=new ArrayList<>();
        for(List<String>list:mp.values()){
            ans.add(list);
        }
        return ans;
    }
}