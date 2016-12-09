package eg.edu.alexu.csd.datastructure.iceHockey.cs73;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

/**
 * @author mahmoud-pc
 */
public class PlayerExtraction implements IPlayersFinder {
  /**
   * the size of the array dpoint which contains all possible directions where
   * the dfs can go.
   */
  private static final int DPOINTSIZE = 4;
  /**
   * the area of 1 cell.
   */
  private static final int CELLAREA = 4;

  /**
   * INDEX0 ---> used as the index in the dPoint array.
   */
  public static final int INDEX0 = 0;
  /**
   * INDEX1 ---> used as the index in the dPoint array.
   */
  public static final int INDEX1 = 1;
  /**
   * INDEX2 ---> used as the index in the dPoint array.
   */
  public static final int INDEX2 = 2;
  /**
   * INDEX3 ---> used as the index in the dPoint array.
   */
  public static final int INDEX3 = 3;
  /**
   * the photo which will be the parameter of the function.
   */
  private String[] photo;
  /**
   * A boolean array used to differentiate between the visited and unvisited
   * node during the dfs operation.
   */
  private boolean[][] visited;
  /**
   * Minimum area of a player.
   */
  private int area;
  /**
   * number of rows a picture has.
   */
  private int row;
  /**
   * number of columns a picture has.
   */
  private int col;
  /**
   * the number that we are looking for during the dfs.
   */
  private int team;
  /**
   * the most point of the current player to the east.
   */
  private int maxX;
  /**
   * the most point of the current player to the north.
   */
  private int maxY;
  /**
   * the most point of the current player to the west.
   */
  private int minX;
  /**
   * the most point of the current player to the south.
   */
  private int minY;
  /**
   * the center of the current player.
   */
  private Point center;

  /**
   * Search for players locations at the given photo.
   * @param myPhoto
   *          Two dimension array of photo contents Will contain between 1 and
   *          50 elements, inclusive.
   * @param myTeam
   *          Identifier of the team
   * @param threshold
   *          Minimum area for an element Will be between 1 and 10000, inclusive
   * @return Array of players locations of the given team
   */
  public final Point[] findPlayers(final String[] myPhoto, final int myTeam,
      final int threshold) {
    ArrayList<Point> ans = new ArrayList<>();
    if (myPhoto.length == 0) {
      return new Point[0];
    }
    set();
    this.team = myTeam;
    this.photo = myPhoto;
    row = photo.length;
    col = photo[0].length();
    visited = new boolean[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (Character.getNumericValue(photo[i].charAt(j)) == team
            && !visited[i][j]) {
          area = 0;
          maxX = -1;
          maxY = -1;
          minX = j;
          minY = i;
          dfs(new Point(j, i));
          if (area >= threshold) {
            center = new Point(maxX + minX + 1, maxY + minY + 1);
            ans.add(center);
          }
        }
      }
    }
    if (ans.size() == 0) {
      return new Point[0];
    }
    Collections.sort(ans, new MyComparator());
    Point[] ret = new Point[ans.size()];
    for (int i = 0; i < ans.size(); i++) {
      ret[i] = ans.get(i);
    }
    return ret;
  }

  /**
   * * * * this array contains the possible directions where the dfs can go. * *
   * * * @see set function
   */
  private Point[] dpoint = new Point[DPOINTSIZE];

  /** * initialization of the dpoint array. */
  final void set() {
    dpoint[INDEX0] = new Point(0, 1);
    dpoint[INDEX1] = new Point(0, -1);
    dpoint[INDEX2] = new Point(1, 0);
    dpoint[INDEX3] = new Point(-1, 0);
  }

  /**
   * @param source
   *          the initial point of the player from which the dfs starts.
   */
  private void dfs(final Point source) {
    area += CELLAREA;
    visited[source.y][source.x] = true;
    maxX = Math.max(source.x, maxX);
    maxY = Math.max(source.y, maxY);
    minX = Math.min(source.x, minX);
    minY = Math.min(source.y, minY);
    for (int i = 0; i < DPOINTSIZE; i++) {
      int nx = source.x + dpoint[i].x;
      int ny = source.y + dpoint[i].y;
      if (nx > -1 && ny > -1 && nx < col && ny < row
          && Character.getNumericValue(photo[ny].charAt(nx)) == team
          && !visited[ny][nx]) {
        dfs(new Point(nx, ny));
      }
    }
  }

  /**
   * @author mahmoud-pc
   */
  private class MyComparator implements Comparator<Point> {
    /**
     * used to sort the result array.
     * @param o1
     *          First point
     * @param o2
     *          second point
     * @return the comparison result
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(final Point o1, final Point o2) {
      if (o1.x == o2.x) {
        return o1.y - o2.y;
      } else {
        return o1.x - o2.x;
      }
    }
  }
}
