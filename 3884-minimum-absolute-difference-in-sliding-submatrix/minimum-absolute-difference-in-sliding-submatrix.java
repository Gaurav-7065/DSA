class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]ans=new int[m-k+1][n-k+1];

        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){
                ArrayList<Integer>list=new ArrayList<>();
                for(int x=i;x<i+k;x++){
                    for(int y=j;y<j+k;y++){
                        list.add(grid[x][y]);
                    }
                }
                Collections.sort(list);
                int min=Integer.MAX_VALUE;
                for(int p=1;p<list.size();p++){
                    if(list.get(p)-list.get(p-1)==0){
                        continue;
                    }
                   min=Math.min(min,list.get(p)-list.get(p-1));
                }
                if(min==Integer.MAX_VALUE){
                    min=0;
                }
                ans[i][j]=min;
            }
        }
        return ans;
    }
}