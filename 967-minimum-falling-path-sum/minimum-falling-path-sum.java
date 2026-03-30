class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, solve(matrix, 0, j, dp));
        }

        return ans;
    }
    public int solve(int[][] matrix,int i,int j,int[][] dp){
        int m = matrix.length;
        int n = matrix[0].length;

        if(j < 0 || j >= n) return Integer.MAX_VALUE;
        if(i==m-1){
            dp[i][j] = matrix[i][j];
            return matrix[i][j];
        }
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int right = solve(matrix,i+1,j,dp);
        int diaright = solve(matrix,i+1,j+1,dp);
        int dialeft = solve(matrix,i+1,j-1,dp);
        dp[i][j] =matrix[i][j] +  Math.min(right,Math.min(diaright,dialeft));
        return dp[i][j];
    }
}