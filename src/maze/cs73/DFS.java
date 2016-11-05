package maze.cs73;

import java.awt.Point;

import stack.cs73.MyStack;

/** Maze Solver using DFS. */
public class DFS {
  /** Stack used in the DFS. */
  private MyStack stack = new MyStack();
  /** Number of rows. */
  private int n;
  /** Number of columns. */
  private int m;

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

  /** A Boolean array to mark the visited nodes. */
  private boolean[][] visited;

  /**
   * An iterative function contains the implementation of the DFS using the
   * stack data structure.
   * @return A 2D integer array represents the path.
   * @param s
   *          the node where the DFS starts (The Source).
   * @param g
   *          a 2D character array represents the graph as an adjacency matrix.
   */
  public final int[][] solve(final Point s, final char[][] g) {
    visited = new boolean[g.length][g[0].length];
    stack.push(s);
    Point top;
    while (!stack.isEmpty()) {
      top = (Point) stack.peek();
      int i = top.x;
      int j = top.y;
      if (g[i][j] == 'E') {
        break;
      }
      visited[i][j] = true;
      if (i - 1 >= 0 && isValid(i - 1, j, g)) {
        stack.push(new Point(i - 1, j));
      } else if (j + 1 < m && isValid(i, j + 1, g)) {
        stack.push(new Point(i, j + 1));
      } else if (i + 1 < n && isValid(i + 1, j, g)) {
        stack.push(new Point(i + 1, j));
      } else if (j - 1 >= 0 && isValid(i, j - 1, g)) {
        stack.push(new Point(i, j - 1));
      } else {
        stack.pop();
      }
    }
    if (stack.size() == 0) {
      return null;
    }
    int[][] ret = new int[stack.size()][2];
    for (int i = stack.size() - 1; i >= 0; i--) {
      ret[i][0] = ((Point) stack.peek()).x;
      ret[i][1] = ((Point) stack.pop()).y;
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
