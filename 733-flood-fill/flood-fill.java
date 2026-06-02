class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prev = image[sr][sc];
        if(prev==color) return image;
        solve(image,sr,sc,prev,color);
        return image;
    }
    public void solve(int[][] image,int r,int c,int prevcolor,int descolor){
        int n = image.length;
        int m = image[0].length;
        if(r<0 || c<0 || r>=n || c>=m){
            return;
        }
        if(image[r][c]!=prevcolor) return;
        image[r][c] = descolor;
        solve(image,r-1,c,prevcolor,descolor);
        solve(image,r,c-1,prevcolor,descolor);
        solve(image,r+1,c,prevcolor,descolor);
        solve(image,r,c+1,prevcolor,descolor);
    }
}