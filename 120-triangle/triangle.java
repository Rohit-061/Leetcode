class Solution {
    int h;
    int[][]dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        h = triangle.size();
        dp = new int[h+1][h+1];
        for(int i=0;i<h;i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        return solve(triangle,0,0);
    }
    public int solve(List<List<Integer>> triangle,int i,int j){
        if(i==h-1) return triangle.get(i).get(j);
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        int down = solve(triangle,i+1,j);
        int diag = solve(triangle,i+1,j+1);
        dp[i][j] = triangle.get(i).get(j) + Math.min(down,diag);
        return dp[i][j];
    }
}