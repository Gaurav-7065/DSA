class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[]freq1=new int[26];
        int[]freq2=new int[26];
        int n1=s1.length();
        int n2=s2.length();

        for(int i=0;i<n1;i++){
            char ch=s1.charAt(i);
            freq1[ch-'a']++;
        }
        int i=0;int j=0;
        while(j<n2){
            char ch=s2.charAt(j);
            if(freq1[ch-'a']==0){
                Arrays.fill(freq2,0);
                j++;
                i=j;
                continue;
            }
            freq2[ch-'a']++;

            while(freq1[ch-'a']<freq2[ch-'a']){
                char chi=s2.charAt(i);
                freq2[chi-'a']--;
                i++;
            }
            if(j-i+1==n1){
                boolean flag=check(freq1,freq2);
                if(flag)return true;
            }
            j++;
        }
        return false;
    }
    public boolean check(int[]freq1,int[]freq2){
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
}