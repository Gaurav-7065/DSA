class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int m=p.length();

        int l=0,r=0;
        List<Integer>list=new ArrayList<>();
        int[]freq1=new int[26];
        int[]freq2=new int[26];
        for(int i=0;i<p.length();i++){
            freq1[p.charAt(i)-'a']++;
        }
        while(r<n){
            char ch=s.charAt(r);
            freq2[ch-'a']++;
            while(r-l+1>m){
                freq2[s.charAt(l)-'a']--;
                l++;
            }
            if(r-l+1==m){
                boolean flag=check(freq1,freq2);
                if(flag){
                    list.add(l);
                }
            }
            r++;
        }
        return list;
    }
    public boolean check(int[]freq1,int[]freq2){
        
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i])return false;
        }
        return true;
    }
}