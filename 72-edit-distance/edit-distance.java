class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n  = s2.length();
        int [][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return solve(s1,s2,0,0,dp);
    }
    public int solve(String s1, String s2, int i,int j,int[][] dp){
        int m = s1.length();
        int n  = s2.length();
        if(i==m) return n-j;
        else if(j==n) return m-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j]=solve(s1,s2,i+1,j+1,dp);
        }
        else{
            int insert = 1 + solve(s1,s2,i,j+1,dp);
            int delete = 1 + solve(s1,s2,i+1,j,dp);
            int replace = 1 + solve(s1,s2,i+1,j+1,dp);
            dp[i][j] =  Math.min(insert,(Math.min(delete,replace)));
        }
        return dp[i][j];
        
    }
}