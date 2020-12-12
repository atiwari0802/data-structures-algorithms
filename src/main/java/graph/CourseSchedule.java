package graph;

import java.util.*;

public class CourseSchedule {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
    Map<Integer, COLOR> visitationMap = new HashMap<>();
    List<Integer> topology = new ArrayList<>();
    boolean isSolutionPossible;

    for (int i = 0; i < numCourses; i++) {
      visitationMap.put(i, COLOR.WHITE);
    }

    for (int i = 0; i < prerequisites.length; i++) {
      int source = prerequisites[i][1];
      int dest = prerequisites[i][0];

      List<Integer> list = adjacencyMap.getOrDefault(source, new ArrayList<>());
      list.add(dest);

      adjacencyMap.put(source, list);
    }

    for (int i = 0; i < numCourses; i++) {
      if (visitationMap.get(i) == COLOR.WHITE) {
        isSolutionPossible = dfs(i, adjacencyMap, visitationMap, topology);
        if (!isSolutionPossible) {
          return new int[] {0};
        }
      }
    }

    Collections.reverse(topology);
    return topology.stream().mapToInt(i -> i).toArray();
  }

  private boolean dfs(
      int node,
      Map<Integer, List<Integer>> adjacencyMap,
      Map<Integer, COLOR> visitationMap,
      List<Integer> topology) {

    visitationMap.put(node, COLOR.GRAY);

    for (int i : adjacencyMap.getOrDefault(node, new ArrayList<>())) {
      if (visitationMap.get(i) == COLOR.WHITE) {
        if (!dfs(i, adjacencyMap, visitationMap, topology)) {
            return false;
        }
      } else if (visitationMap.get(i) == COLOR.GRAY) {
        return false;
      }
    }

    visitationMap.put(node, COLOR.BLACK);
    topology.add(node);
    return true;
  }

  enum COLOR {
    WHITE,
    BLACK,
    GRAY
  }
}
