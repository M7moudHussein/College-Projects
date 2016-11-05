package maze.cs73;

import java.awt.Point;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import maze.IMazeSolver;

/** Maze solver implementation. */
public class MazeSolver implements IMazeSolver {
  /** A 2D character array to represent the graph. */
  private char[][] g;
  /** Number of rows. */
  private int n = -1;
  /** Number of columns. */
  private int m = -1;
  /** An arrayList that will be used to represent the path. */
  private Point s;

  @Override
  public final int[][] solveBFS(final File maze) {
    fileReader(maze);
    BFS solver = new BFS();
    solver.set(n, m);
    return solver.solve(s, g);
  }

  @Override
  public final int[][] solveDFS(final File maze) {
    fileReader(maze);
    DFS solver = new DFS();
    solver.set(n, m);
    return solver.solve(s, g);
  }

  /**
   * Used to read the input.
   * @param maze
   *          A file to read form
   */
  private void fileReader(final File maze) {
    boolean exitFound = false;
    try {
      @SuppressWarnings("resource")
      Scanner sc = new Scanner(maze);
      Matcher myMatcher = Pattern.compile("\\d+").matcher(sc.nextLine());
      if (myMatcher.find()) {
        n = Integer.valueOf(myMatcher.group());
      }
      if (myMatcher.find()) {
        m = Integer.valueOf(myMatcher.group());
      }
      if (n * m <= 1) {
        throw new Exception();
      }
      g = new char[n][m];
      String temp;
      for (int i = 0; sc.hasNextLine(); i++) {
        temp = sc.nextLine();
        if (temp.length() != m || i >= n) {
          throw new Exception();
        }
        for (int j = 0; j < m; j++) {
          g[i][j] = temp.charAt(j);
          if (g[i][j] == 'S') {
            s = new Point(i, j);
          } else if (g[i][j] != '.' && g[i][j] != '#' && g[i][j] != 'E') {
            throw new Exception();
          }
          if (g[i][j] == 'E') {
            exitFound = true;
          }
        }
      }
      if (!exitFound) {
        throw new Exception();
      }
    } catch (Exception e) {
      throw new RuntimeException("Wrong Input.");
    }
  }

  // public static void main(String[] args) {
  // MazeSolver mySolver = new MazeSolver();
  // int[][] ans;
  // ans = mySolver.solveDFS(new File("input.txt"));
  // for (int i = 0; i < ans.length; i++) {
  // if (i % 5 == 0)
  // System.out.println();
  // System.out.print("(" + ans[i][0] + "," + ans[i][1] + ")");
  // System.out.print(" --> ");
  // }
  // }
}
