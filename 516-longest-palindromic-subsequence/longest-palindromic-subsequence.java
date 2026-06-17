class Solution {
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int m =r.length();

        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<n+1 ; i++){
            for(int j=0;j<m+1;j++ ){
                dp[i][j] = -1;
            }
        }
        return solve(n,m,s,r,dp);
    }
    public int solve(int i,int j,String s, String r, int[][] dp){
        if(i==0 || j==0){
            dp[i][j] = 0;
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i-1)==r.charAt(j-1)){
            dp[i][j]=1 + solve(i-1,j-1,s,r,dp);
        }
        else{
            int case1 = solve(i-1,j,s,r,dp);
            int case2 = solve(i,j-1,s,r,dp);
            dp[i][j] = Math.max(case1,case2);
                
        }
        return dp[i][j];
    }
}