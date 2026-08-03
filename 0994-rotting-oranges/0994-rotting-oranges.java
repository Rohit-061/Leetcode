class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    fresh++;
                }if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        if(fresh==0) return 0;

        int time=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] loc = q.poll();
                int r = loc[0];
                int c = loc[1];
                int[][] neigh = {{r-1,c},{r,c-1},{r+1,c},{r,c+1}};
                for(int neighbour[] : neigh){
                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    if(nr<0 || nr>=n || nc<0 || nc>=m || grid[nr][nc]==2 || grid[nr][nc]==0){
                        continue;
                    }
                    q.offer(new int[]{nr,nc});
                    grid[nr][nc] = 2;
                }
            }
            time++;
            fresh -=q.size();
            if(fresh==0) break;
        }
        return (fresh==0)?time:-1;
    }
}