// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule1 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] preRequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] row : preRequisites) {
            adjList.get(row[0]).add(row[1]);
        }
        Solution solution = new Solution();
        boolean completed = solution.checkIfCoursePossible(adjList);
        System.out.println("can the given course be completed in order ? :" + completed);
    }

    private static class Solution {
        private boolean checkIfCoursePossible(List<List<Integer>> adjList) {
            int inDegree[] = new int[adjList.size()];
            List<Integer> topoList = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < adjList.size(); i++) {
                for (int j = 0; j < adjList.get(i).size(); j++) {
                    inDegree[adjList.get(i).get(j)]++;
                }
            }
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0)
                    queue.add(i);
            }
            while (!queue.isEmpty()) {
                int node = queue.poll();
                topoList.add(node);
                for (int i = 0; i < adjList.get(node).size(); i++) {
                    inDegree[adjList.get(node).get(i)]--;
                    if (inDegree[adjList.get(node).get(i)] == 0)
                        queue.add(adjList.get(node).get(i));
                }
            }
            return topoList.size() == adjList.size();
        }
    }
}
