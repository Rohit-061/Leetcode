class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,grid,dp);
    }
    public int solve(int i,int j,int[][] grid,int[][] dp){
        int n = grid.length;
        int m = grid[0].length;
        if(i==n-1 && j==m-1){
            dp[i][j] = grid[i][j]; 
            return grid[i][j];
        }
        if(i>=n || j>=m) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int right = solve(i,j+1,grid,dp);
        int down =  solve(i+1,j,grid,dp);
        dp[i][j] = grid[i][j] + Math.min(right,down);
        return dp[i][j];
    }
}