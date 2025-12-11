class Solution {
    public int minimumTotal(List<List<Integer>> triangle){
        int h = triangle.size();
        int[][] dp = new int [h][h];
        for(int i=0;i<h;i++){
            for(int j=0;j<h;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        return solve(triangle,dp ,0,0);


    }
    public int solve(List<List<Integer>> triangle,int[][]dp,int i, int j){
        int h = triangle.size();
        if(i==h-1) return triangle.get(i).get(j);
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        int down = solve(triangle, dp , i+1,j);
        int diag = solve(triangle,dp , i+1 , j+1);
        dp[i][j] = triangle.get(i).get(j) + Math.min(down,diag);
        return dp[i][j];
    }
}