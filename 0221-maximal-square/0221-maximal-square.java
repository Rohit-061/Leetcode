class Solution {
    int max=0;
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        solve(matrix,0,0,dp);
        return max*max;

    }
    public int solve(char[][] matrix,int i,int j,int[][] dp){
        int n=matrix.length;
        int m=matrix[0].length;
        
        if(i>=n || j>=m){
            return 0;
        }

        if(dp[i][j]!=-1) return dp[i][j];
        int right = solve(matrix,i,j+1,dp);
        int down = solve(matrix,i+1,j,dp);
        int dia = solve(matrix,i+1,j+1,dp);
       if (matrix[i][j] == '1') {
            dp[i][j] = 1 + Math.min(right, Math.min(down, dia));
            max = Math.max(max, dp[i][j]);
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j];
        
    }
}