class Solution {
    public boolean isPalindrome(int x) {
        int palind=0;
        int y=x;
        while(y>0){
            int rem=y%10;
            palind=palind*10+rem;
            y=y/10;
        }
        if(palind==x)return true;
        else return false;
    }
}