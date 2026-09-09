class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[]maxRow=new int[n+1];
        int[]minRow=new int[n+1];
        int[]minCol=new int[n+1];
        int[]maxCol=new int[n+1];
        
        Arrays.fill(minRow,n+1);
        Arrays.fill(minCol,n+1);


        for(int[]b:buildings){
            int row=b[0];
            int col=b[1];
            minRow[row]=Math.min(minRow[row],col);
            maxRow[row]=Math.max(maxRow[row],col);

            minCol[col]=Math.min(minCol[col],row);
            maxCol[col]=Math.max(maxCol[col],row);
        }

        int count=0;

        for(int[]b:buildings){
            int row=b[0];
            int col=b[1];

            boolean vertical=minCol[col]<row &&maxCol[col]>row;
            boolean horizontal=minRow[row]<col &&maxRow[row]>col;

            if(vertical&&horizontal){
                count++;
            }
        }
        return count;
    }
}