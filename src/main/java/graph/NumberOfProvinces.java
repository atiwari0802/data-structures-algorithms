package graph;

public class NumberOfProvinces {

  /**
   * Time Complexity: O(n ^ 2)
   * Space Complexity: O(n)
   * @param M
   * @return
   */
  public int findCircleNum(int[][] M) {
    int[] visited = new int[M.length];
    int count = 0;

    for (int i = 0; i < M.length; i++) {
      if (visited[i] == 0) {
        dfs(M, visited, i);
        count++;
      }
    }

    return count;
  }

  private void dfs(int[][] M, int[] visited, int node) {
    for (int j = 0; j < M.length; j++) {
      if (node != j && M[node][j] == 1 && visited[j] == 0) {
        visited[j] = 1;
        dfs(M, visited, j);
      }
    }
  }
}
