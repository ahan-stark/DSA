// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
// same problem as course schedule 1 but here dependency will be opposite [1,0] generally 1 should complete before 0, but in this question its opposite 0 should complete before 1.. so change the order in ans as  To take course 0 you should have finished course 1. So the correct course order is[1,0] - > [0,1] 
//below input to go to 1 0 to be completed.. 2 ..0 has to be completed..so while solving reverse each order 0->1... 0->2
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 } };
        int numCourses = 4;
        Solution solution = new Solution();
        int newArr[] = solution.getCourseOrder(numCourses, prerequisites);
        for (int val : newArr) {
            System.out.println(val);
        }
    }

    private static class Solution {
        private int[] getCourseOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjList = new ArrayList<>();
            List<Integer> topoList = new ArrayList<>();
            int[] inDegree = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] row : prerequisites) {
                adjList.get(row[1]).add(row[0]);
            }
            for (int i = 0; i < adjList.size(); i++) {
                for (int j = 0; j < adjList.get(i).size(); j++) {
                    inDegree[adjList.get(i).get(j)]++;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < adjList.size(); i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int i = 0;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                topoList.add(i++, node);
                for (int j = 0; j < adjList.get(node).size(); j++) {
                    inDegree[adjList.get(node).get(j)]--;
                    if (inDegree[adjList.get(node).get(j)] == 0)
                        queue.offer(adjList.get(node).get(j));
                }
            }
            if (topoList.size() != numCourses) {
                return new int[] {};
            }
            int ansArr[] = new int[topoList.size()];
            i = 0;
            for (Integer val : topoList) {
                ansArr[i++] = val;
            }
            return ansArr;
        }

    }
}
// apply the same kahn's algo and create the correesponding edgeList.. but in
// question the direction is given opposite [1,0] that is 0 -> 1 so change it to
// general form of 1 - > 0 [0,1]