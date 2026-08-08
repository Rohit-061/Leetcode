class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] num : prerequisites){
            int a=num[0];
            int b = num[1];
            graph.get(b).add(a);
            indeg[a]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            for (int next : graph.get(curr)) {
                indeg[next]--;
                if (indeg[next] == 0) queue.offer(next);
            }
        }

        return count == numCourses;
    }
}