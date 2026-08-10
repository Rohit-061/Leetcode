class Solution {
    int m,n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        int [][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,dp,obstacleGrid);
    }
    public int solve(int i, int j, int [][] dp,int[][] obstacleGrid){
        if(i>=m || j>=n || obstacleGrid[i][j]==1){
            return 0;
        }
        if (i == m - 1 && j == n - 1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int right = solve(i,j+1,dp,obstacleGrid);
        int down = solve(i+1,j,dp,obstacleGrid);
        return dp[i][j] = right + down;
    }
}