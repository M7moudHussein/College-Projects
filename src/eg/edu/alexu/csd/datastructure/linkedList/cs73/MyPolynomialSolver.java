package eg.edu.alexu.csd.datastructure.linkedList.cs73;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

/**
 * A polynomial solver class.
 */
public class MyPolynomialSolver implements IPolynomialSolver {

  /**
   * Polynomial A.
   */
  private SinglyLinkedList polyA;
  /**
   * Polynomial B.
   */
  private SinglyLinkedList polyB;
  /**
   * Polynomial C.
   */
  private SinglyLinkedList polyC;
  /**
   * The result Polynomial.
   */
  private SinglyLinkedList polyR;
  /**
   * A Maximum array size to set the size of An array used in the multiply
   * function.
   */
  public static final int MAXARRAYSIZE = 99999;

  /**
   * Set polynomial terms (coefficients & exponents).
   * @see Function wich uses different parameters Also calls Function
   *      SetPolynomial
   * @param poly
   *          name of the polynomial
   * @param terms
   *          array of [coefficients][exponents]
   */
  public final void setPolynomial(final char poly, final int[][] terms) {
    if (poly == 'A') {
      polyA = new SinglyLinkedList();
      setPolynomial(polyA, terms);
    } else if (poly == 'B') {
      polyB = new SinglyLinkedList();
      setPolynomial(polyB, terms);
    } else if (poly == 'C') {
      polyC = new SinglyLinkedList();
      setPolynomial(polyC, terms);
    } else if (poly == 'R') {
      polyR = new SinglyLinkedList();
      setPolynomial(polyR, terms);
    } else {
      throw new RuntimeException("WrongLinkedListChosen");
    }
  }

  /**
   * used in function setPoylomial.
   * @param ployx
   *          A polynomial to be Set
   * @param terms
   *          the input polynomial
   * @see functin setPolynomial
   */
  final void setPolynomial(final SinglyLinkedList ployx, final int[][] terms) {
    if (terms.length == 0) {
      throw new RuntimeException("EmptyPolynomialInserted");
    }
    for (int i = 0; i < terms.length; i++) {
      ployx.add(new Point(terms[i][0], terms[i][1]));
      if (i != 0 && terms[i - 1][1] <= terms[i][1]) {
        throw new RuntimeException("WrongArrangement");
      } else if (terms[i][1] < 0) {
        throw new RuntimeException("NegativeExponentNotAccepted");
      }
    }
  }

  /**
   * Print the polynomial in human readable representation.
   * @param poly
   *          name of the polynomial
   * @return polynomial in the form like 27x^2+x-1
   */
  public final String print(final char poly) {
    String result = new String();
    SinglyLinkedList temp;
    if (poly == 'A') {
      temp = polyA;
    } else if (poly == 'B') {
      temp = polyB;
    } else if (poly == 'C') {
      temp = polyC;
    } else if (poly == 'R') {
      temp = polyR;
    } else {
      throw new RuntimeException("WrongPolynomialChosen");
    }
    if (temp == null) {
      return null;
    }
    if (temp.size() == 0) {
      result += "0";
    } else {
      int coof = ((Point) temp.get(0)).x;
      int power = ((Point) temp.get(0)).y;
      if ((coof == 1 && power == 0) || coof != 1) {
        result += String.valueOf(coof);
      }
      if (power != 0) {
        result += "x";
      }
      if (power != 0 && power != 1) {
        result += "^" + String.valueOf(power);
      }
      for (int i = 1; i < temp.size(); i++) {
        coof = ((Point) temp.get(i)).x;
        power = ((Point) temp.get(i)).y;
        if (coof > 0) {
          result += "+";
        }
        if ((coof == 1 && power == 0) || coof != 1) {
          result += String.valueOf(coof);
        }
        if (power != 0) {
          result += "x";
        }
        if (power != 1 && power != 0) {
          result += "^" + String.valueOf(power);
        }
      }
    }
    return result;
  }

  /**
   * Clear the polynomial.
   * @param poly
   *          name of the polynomial
   */
  public final void clearPolynomial(final char poly) {
    if (poly == 'A' && polyA != null) {
      polyA = null;
    } else if (poly == 'B' && polyB != null) {
      polyB = null;
    } else if (poly == 'C' && polyC != null) {
      polyC = null;
    } else if (poly == 'R' && polyR != null) {
      polyR = null;
    } else {
      throw new RuntimeException("WrongPolynomialChosen");
    }
  }

  /**
   * Evaluate the polynomial.
   * @param poly
   *          name of the polynomial
   * @param value
   *          polynomial constant value
   * @return the value of the polynomial
   */
  public final float evaluatePolynomial(final char poly, final float value) {
    float result = 0;
    SinglyLinkedList temp = new SinglyLinkedList();
    if (poly == 'A') {
      temp = polyA;
    } else if (poly == 'B') {
      temp = polyB;
    } else if (poly == 'C') {
      temp = polyC;
    } else {
      temp = polyR;
    }
    for (int i = 0; i < temp.size(); i++) {
      result += ((Point) temp.get(i)).x
          * Math.pow(value, ((Point) temp.get(i)).y);
    }
    return result;
  }

  /**
   * Add two polynomials.
   * @param poly1
   *          first polynomial
   * @param poly2
   *          second polynomial
   * @return the result polynomial
   */
  public final int[][] add(final char poly1, final char poly2) {
    polyR = new SinglyLinkedList();
    SinglyLinkedList tempPolyx = new SinglyLinkedList();
    SinglyLinkedList tempPolyy = new SinglyLinkedList();
    if (poly1 == 'A' || poly1 == 'B') {
      if (poly1 == 'A') {
        tempPolyx = polyA;
      } else {
        tempPolyx = polyB;
      }
    } else if (poly1 == 'C') {
      tempPolyx = polyC;
    } else {
      throw new RuntimeException("OperationOnPolynomial'Z'IsNotPermitted");
    }
    if (poly2 == 'A' || poly2 == 'B') {
      if (poly2 == 'A') {
        tempPolyy = polyA;
      } else {
        tempPolyy = polyB;
      }
    } else if (poly2 == 'C') {
      tempPolyy = polyC;
    } else {
      throw new RuntimeException("OperationOnPolynomial'Z'IsNotPermitted");
    }
    if (tempPolyx == null || tempPolyy == null) {
      throw new RuntimeException("InsertThePolynomialBeforeOperation");
    }
    for (int i = 0; i < tempPolyx.size(); i++) {
      polyR.add(tempPolyx.get(i));
    }
    for (int i = 0; i < tempPolyy.size(); i++) {
      boolean taken = false;
      for (int j = 0; j < polyR.size(); j++) {
        if (((Point) polyR.get(j)).y == ((Point) tempPolyy.get(i)).y) {
          int sum = ((Point) polyR.get(j)).x + ((Point) tempPolyy.get(i)).x;
          if (sum != 0) {
            polyR.set(j, new Point(sum, ((Point) polyR.get(j)).y));
          } else {
            polyR.remove(j);
          }
          taken = true;
          break;
        }
      }
      if (!taken) {
        polyR.add(tempPolyy.get(i));
      }
    }
    polyR.sort();
    if (polyR.size() == 0) {
      int[][] ret = {{0, 0}};
      return ret;
    }
    int[][] ret = new int[polyR.size()][2];
    for (int i = 0; i < ret.length; i++) {
      ret[i][0] = ((Point) polyR.get(i)).x;
      ret[i][1] = ((Point) polyR.get(i)).y;
    }
    return ret;
  }

  /**
   * Subtract two polynomials.
   * @param poly1
   *          first polynomial
   * @param poly2
   *          second polynomial
   * @return the result polynomial
   */
  public final int[][] subtract(final char poly1, final char poly2) {
    polyR = new SinglyLinkedList();
    SinglyLinkedList tempPolyx = new SinglyLinkedList();
    SinglyLinkedList tempPolyy = new SinglyLinkedList();
    if (poly1 == 'A' || poly1 == 'B') {
      if (poly1 == 'A') {
        tempPolyx = polyA;
      } else {
        tempPolyx = polyB;
      }
    } else {
      tempPolyx = polyC;
    }
    if (poly2 == 'A' || poly2 == 'B') {
      if (poly2 == 'A') {
        tempPolyy = polyA;
      } else {
        tempPolyy = polyB;
      }
    } else {
      tempPolyy = polyC;
    }
    if (tempPolyx == null || tempPolyy == null) {
      throw new RuntimeException("InsertThePolynomialBeforeOperation");
    }
    for (int i = 0; i < tempPolyx.size(); i++) {
      polyR.add(tempPolyx.get(i));
    }
    for (int i = 0; i < tempPolyy.size(); i++) {
      boolean taken = false;
      for (int j = 0; j < polyR.size(); j++) {
        if (((Point) polyR.get(j)).y == ((Point) tempPolyy.get(i)).y) {
          int sum = ((Point) polyR.get(j)).x - ((Point) tempPolyy.get(i)).x;
          if (sum != 0) {
            polyR.set(j, new Point(sum, ((Point) polyR.get(j)).y));
          } else {
            polyR.remove(j);
          }
          taken = true;
          break;
        }
      }
      if (!taken) {
        polyR.add(new Point(-1 * ((Point) tempPolyy.get(i)).x,
            ((Point) tempPolyy.get(i)).y));
      }
    }
    polyR.sort();
    if (polyR.size() == 0) {
      int[][] ret = {{0, 0}};
      return ret;
    }
    int[][] ret = new int[polyR.size()][2];
    for (int i = 0; i < ret.length; i++) {
      ret[i][0] = ((Point) polyR.get(i)).x;
      ret[i][1] = ((Point) polyR.get(i)).y;
    }
    return ret;
  }

  /**
   * Multiply two polynomials.
   * @param poly1
   *          first polynomial
   * @param poly2
   *          second polynomial
   * @return the result polynomial
   */
  public final int[][] multiply(final char poly1, final char poly2) {
    SinglyLinkedList tempPolyx = new SinglyLinkedList();
    SinglyLinkedList tempPolyy = new SinglyLinkedList();
    polyR = new SinglyLinkedList();
    if (poly1 == 'A' || poly1 == 'B') {
      if (poly1 == 'A') {
        tempPolyx = polyA;
      } else {
        tempPolyx = polyB;
      }
    } else {
      tempPolyx = polyC;
    }
    if (poly2 == 'A' || poly2 == 'B') {
      if (poly2 == 'A') {
        tempPolyy = polyA;
      } else {
        tempPolyy = polyB;
      }
    } else {
      tempPolyy = polyC;
    }
    if (tempPolyx == null || tempPolyy == null) {
      throw new RuntimeException("InsertThePolynomialBeforeOperation");
    }
    int counter = 0;
    Point[] temp = new Point[MAXARRAYSIZE];
    Arrays.fill(temp, new Point());
    for (int i = 0; i < tempPolyx.size(); i++) {
      for (int j = 0; j < tempPolyy.size(); j++) {
        temp[counter++] = new Point(
            ((Point) tempPolyx.get(i)).x * ((Point) tempPolyy.get(j)).x,
            ((Point) tempPolyx.get(i)).y + ((Point) tempPolyy.get(j)).y);
      }
    }
    MyComp comp = new MyComp();
    Arrays.sort(temp, 0, counter, comp);
    for (int i = 0; i < counter; i++) {
      int sum = temp[i].x;
      while (i < counter && temp[i].y == temp[i + 1].y) {
        sum += temp[i + 1].x;
        i++;
      }
      if (sum != 0) {
        polyR.add(new Point(sum, temp[i].y));
      }
    }
    int[][] ret = new int[polyR.size()][2];
    for (int i = 0; i < polyR.size(); i++) {
      ret[i][0] = ((Point) polyR.get(i)).x;
      ret[i][1] = ((Point) polyR.get(i)).y;
    }
    return ret;
  }

  /**
   * Comparator to compare Points Used in sorting.
   * @see line3 05
   */

  private class MyComp implements Comparator<Point> {
    /**
     * @param o1
     *          first object to be compared
     * @param o2
     *          Second object to be compared
     * @return an integer to indicate how to sort o1 and o2
     */
    public int compare(final Point o1, final Point o2) {
      return o2.y - o1.y;
    }
  }
}
