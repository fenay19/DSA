class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

        int [][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

return finalpath(0,0,n,m,dp,obstacleGrid);
    }

    int finalpath(int i,int j,int n,int m,int [][] dp ,int[][]obs ){

        if(i>=m || i<0 || j>=n||j<0) return 0;
        if(obs[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==m-1 && j==n-1) return 1;
        return dp[i][j]=finalpath(i+1,j,n,m,dp,obs)+finalpath(i,j+1,n,m,dp,obs);

    }
}