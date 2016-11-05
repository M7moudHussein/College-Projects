package maze.cs73;

import java.awt.Point;

import queue.cs73.QueueLinked;

/** Maze Solver using DFS. */
public class BFS {
  /** queue used in the DFS. */
  private QueueLinked q = new QueueLinked();
  /** Number of rows. */
  private int n;
  /** Number of columns. */
  private int m;
  /** A Boolean array to mark the visited nodes. */
  private boolean[][] visited;
  /** An array to used to print the Path. */
  private Point[][] path;
  /** A point stores the coordinates of the target. */
  private Point target = null;

  /**
   * sets the number of rows & columns.
   * @param myN
   *          number of rows.
   * @param myM
   *          number of columns.
   */
  public final void set(final int myN, final int myM) {
    n = myN;
    m = myM;
  }

  /** To get the path. */

  /**
   * An iterative function contains the implementation of the BFS using the
   * queue data structure.
   * @return A 2D integer array represents the path.
   * @param s
   *          the node where the DFS starts (The Source).
   * @param g
   *          a 2D character array represents the graph as an adjacency matrix.
   */
  public final int[][] solve(final Point s, final char[][] g) {
    int[][] temp = new int[g.length * g[0].length][2];
    int cnt = 0;
    visited = new boolean[g.length][g[0].length];
    path = new Point[g.length][g[0].length];
    path[s.x][s.y] = new Point(s);
    Point top;
    q.enqueue(s);
    while (!q.isEmpty()) {
      top = (Point) q.dequeue();
      visited[top.x][top.y] = true;
      int i = top.x;
      int j = top.y;
      if (g[i][j] == 'E') {
        target = new Point(i, j);
        break;
      }
      if (i - 1 >= 0 && isValid(i - 1, j, g)) {
        q.enqueue(new Point(i - 1, j));
        path[i - 1][j] = top;
      }
      if (j + 1 < m && isValid(i, j + 1, g)) {
        q.enqueue(new Point(i, j + 1));
        path[i][j + 1] = top;
      }

      if (i + 1 < n && isValid(i + 1, j, g)) {
        q.enqueue(new Point(i + 1, j));
        path[i + 1][j] = top;
      }

      if (j - 1 >= 0 && isValid(i, j - 1, g)) {
        q.enqueue(new Point(i, j - 1));
        path[i][j - 1] = top;
      }
    }
    if (target == null) {
      return null;
    }
    Point j = target;
    while (!path[j.x][j.y].equals(j)) {
      temp[cnt][0] = j.x;
      temp[cnt++][1] = j.y;
      j = path[j.x][j.y];
    }
    temp[cnt][0] = s.x;
    temp[cnt++][1] = s.y;
    int[][] ret = new int[cnt][2];
    for (int i = 0; i < cnt; i++) {
      ret[i][0] = temp[cnt - 1 - i][0];
      ret[i][1] = temp[cnt - 1 - i][1];
    }
    return ret;
  }

  /**
   * checks if the node is valid to be visited or not.
   * @param y
   *          row index
   * @param x
   *          column index
   * @param g
   *          2D character array represents the graph.
   * @return true if the node is valid to be visited.
   */
  private boolean isValid(final int y, final int x, final char[][] g) {
    if (visited[y][x]) {
      return false;
    }
    if (g[y][x] != '.' && g[y][x] != 'E') {
      return false;
    }
    return true;
  }
}
