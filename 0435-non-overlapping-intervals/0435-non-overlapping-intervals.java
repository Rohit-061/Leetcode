class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int n = intervals.length;
        int m = intervals[0].length;
        int count=0;
        int last = intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<last){
                count++;
            }else{
                last = intervals[i][1];
            }
        }
        return count;
    }
}