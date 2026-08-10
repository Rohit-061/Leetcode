class Solution {
    int n;
    public boolean stoneGame(int[] piles) {
        n = piles.length;
        int sum = 0;
        for(int num : piles){
            sum += num;
        }
        int[][] dp = new int[501][501];
        for(int i=0;i<501;i++){
            Arrays.fill(dp[i],-1);
        }
        int alice_score = solve(0,n-1,piles,dp);
        return alice_score > sum/2;
        
    }
    public int solve(int i,int j, int[] piles,int[][] dp){
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int take_i = piles[i] + Math.min(solve(i+2,j,piles,dp),solve(i+1,j-1,piles,dp));
        int take_j = piles[j] + Math.min(solve(i+1,j-1,piles,dp),solve(i,j-2,piles,dp));

        dp[i][j] = Math.max(take_i,take_j);
        return dp[i][j];
    }
}