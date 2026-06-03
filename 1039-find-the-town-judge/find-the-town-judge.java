class Solution {
    public int findJudge(int n, int[][] trust) {
        int len = trust.length;
        if(len<n-1) return -1;
        int [] degree = new int[n+1];
        for(int i=0;i<len;i++){
            degree[trust[i][0]]--;
            degree[trust[i][1]]++;
        }
        for(int i=1;i<n+1;i++){
            if(degree[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}