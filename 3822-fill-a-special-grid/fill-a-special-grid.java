class Solution {
    int count=0;
    public int[][] specialGrid(int n) {
        int size=(int)Math.pow(2,n);
        int[][]grid=new int[size][size];

        fill(grid,0,size,0,size);
        return grid;
    }
    void fill(int[][]grid,int r1,int r2,int c1,int c2){
        if(r2-r1==1){
            grid[r1][c1]=count++;
            return;
        }
        int midRow=(r1+r2)/2;
        int midCol=(c1+c2)/2;
       
        fill(grid,r1,midRow,midCol,c2);
        fill(grid,midRow,r2,midCol,c2);
        fill(grid,midRow,r2,c1,midCol);
        fill(grid,r1,midRow,c1,midCol);
    }
}