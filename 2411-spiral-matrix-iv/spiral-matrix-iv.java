class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(mat[i], -1);
        }

        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = m - 1;

        ListNode temp = head;
        while (temp != null) {
            for (int i = l; i <= r; i++) {
                if (temp != null) {

                    mat[t][i] = temp.val;
                    temp = temp.next;
                    
                }
            }
            t++;
            for (int i = t; i <= b; i++) {
                if (temp != null) {
                    mat[i][r] = temp.val;
                    temp = temp.next;
                    
                }
            }
            r--;
            for(int i=r;i>=l;i--){
                if(temp!=null){
                    mat[b][i]=temp.val;
                    temp=temp.next;
                    
                }
            }
            b--;
            for(int i=b;i>=t;i--){
                if(temp!=null){
                    mat[i][l]=temp.val;
                    temp=temp.next;
                    
                }
            }
            l++;
        }
        return  mat;
    }
}