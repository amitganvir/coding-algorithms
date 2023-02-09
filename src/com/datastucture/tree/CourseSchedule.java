package com.datastucture.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

    public static void main(String[] args) {
        //boolean result = canFinish(3, new int[][]{{1, 0}, {0, 2}, {2, 1}});
        //boolean result = canFinish(3, new int[][]{{1, 0}});
        //boolean result = canFinish(3, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}});
        boolean result = canFinish(9, new int[][]{{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}});
        System.out.println("Result " + result);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> dependencies = buildDependencies(prerequisites);
        int[] visited = new int[numCourses];

        for (int[] course : prerequisites) {

            if (!canFinishThisCourse(course[0], dependencies, visited)) {
                return false;
            }
        }

        return true;
    }

    private static boolean canFinishThisCourse(int courseToTake, Map<Integer, Set<Integer>> dependencies, int[] visited) {

        if (visited[courseToTake] == -1) {
            return false;
        }

        if (visited[courseToTake] == 1) {
            return true;
        }

        visited[courseToTake] = -1;

        if (dependencies.containsKey(courseToTake)) {
            Set<Integer> dependenciesSet = dependencies.get(courseToTake);
            for (Integer dependency : dependenciesSet) {
                if (!canFinishThisCourse(dependency, dependencies, visited)) {
                    return false;
                }
            }
        }

        visited[courseToTake] = 1;
        return true;
    }

    private static Map<Integer, Set<Integer>> buildDependencies(int[][] prerequisites) {

        Map<Integer, Set<Integer>> courseDependencies = new HashMap<>();

        for (int[] course : prerequisites) {
            Set<Integer> depCourses = courseDependencies.getOrDefault(course[0], new HashSet<Integer>());
            depCourses.add(course[1]);
            courseDependencies.put(course[0], depCourses);
        }

        return courseDependencies;
    }

}
