import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
  
    /**
    * This method calculates the minimum number of groups needed such that
    * each group consists of non-overlapping intervals from the given array of intervals.
    * Intervals are considered to have a start and an end, and overlapping intervals cannot
    * be in the same group.
    *
    * @param intervals Array of intervals where each interval is represented by a pair [start, end].
    * @return The minimum number of groups required.
    */
    public int minGroups(int[][] intervals) {
        // Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      
        // A priority queue to manage the end times of the intervals
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
      
        // Iterate over all intervals
        for (int[] interval : intervals) {
            // If the queue is not empty and the smallest end time is less than the
            // start of the current interval, we can reuse this group for the new interval
            if (!endTimeQueue.isEmpty() && endTimeQueue.peek() < interval[0]) {
                endTimeQueue.poll(); // Remove the interval with the smallest end time
            }
          
            // Add the current interval's end time to the queue
            endTimeQueue.offer(interval[1]);
        }
      
        // The size of the priority queue indicates the minimum number of groups needed
        return endTimeQueue.size();
    }
}