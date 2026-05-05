class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int p1=0,p2=0;
        while(p1<g.length && p2<s.length){
            if(s[p2]>=g[p1]){
                count++;
                p1++;
                p2++;
            }else {
                p2++;
            }
        }
        return count;
    }
}