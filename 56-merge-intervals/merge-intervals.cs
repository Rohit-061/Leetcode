public class Solution {
    public int[][] Merge(int[][] intervals) {
        if(intervals.Length == 0) return new int[0][];
        Array.Sort(intervals,(a,b) => a[0].CompareTo(b[0]));
        List<int[]> merged = new List<int[]>();
        int[] curr = intervals[0];
        foreach(var inter in intervals){
            if(curr[1]>=inter[0]){
                curr[1] = Math.Max(curr[1],inter[1]);
            }
            else{
                merged.Add(curr);
                curr = inter;
            }
        }
        merged.Add(curr);
        return merged.ToArray();
    }
}