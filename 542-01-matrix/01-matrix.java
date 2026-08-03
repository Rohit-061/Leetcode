class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dis = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    queue.offer(new int[]{i,j});
                    vis[i][j]=true;
                }
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0] , c = cell[1];
            for(int[] d: dirs){
                int nr = r + d[0], nc = c + d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc]){
                    dis[nr][nc] = dis[r][c] + 1;
                    vis[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return dis;

    }
}