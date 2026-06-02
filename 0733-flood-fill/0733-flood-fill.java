class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prev = image[sr][sc];
        if(prev==color) return image;
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        image[sr][sc] = color;
       int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && image[nr][nc] == prev) {
                    image[nr][nc] = color; 
                    q.add(new int[]{nr, nc}); 
                }
            }
        }

        return image;
    }
}