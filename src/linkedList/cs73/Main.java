package linkedList.cs73;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The Main function which also includes the user interface.
 */
public class Main {
  /**
   * A Boolean To check if polynomial A is set Or not.
   */
  private static boolean aIsSet;
  /**
   * A Boolean To check if polynomial B is set Or not.
   */
  private static boolean bIsSet;
  /**
   * A Boolean To check if polynomial C is set Or not.
   */
  private static boolean cIsSet;
  /**
   * An object from the polynomial solver.
   */
  private static PolynomialSolverImp obj = new PolynomialSolverImp();
  /** A user choice to add. */
  private static final int ADDCHOICE = 3;
  /** A user choice subtract add. */
  private static final int SUBTRACTCHOICE = 4;
  /** A user choice to multiply. */
  private static final int MULTIPLYCHOICE = 5;
  /** A user choice to evaluate. */
  private static final int EVALUATECHOICE = 6;
  /** A user choice to clear a specific polynomial. */
  private static final int CLEARPOLYNOMIALCHOICEC = 7;

  /**
   * The Main Method with includes the user interface.
   * @param args
   *          Main function arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    int choice;
    System.out.println("Please choose an action");
    System.out.println("-----------------------");
    System.out.println("1 - Set a polynomial variable");
    System.out.println("2 - Print the value of a polynomial variable");
    System.out.println("3 - Add two polynomials");
    System.out.println("4 - Subtract two polynomials");
    System.out.println("5 - Multiply two polynomials");
    System.out.println("6 - Evaluate a polynomial at some point");
    System.out.println("7 - Clear a polynomial variable");
    System.out.println(
        "====================================================================");
    while (true) {
      choice = sc.nextInt();
      if (choice == 1) {
        System.out.println("Insert the variable name : A , B or C");
        char poly;
        poly = sc.next().charAt(0);
        System.out.println("Insert the polynomial terms in the form :");
        System.out
            .println("( coeff1 , exponent1 ) , ( coeff2 , exponent2 ) , ..");
        Pattern mypattern = Pattern
            .compile("\\s*-?\\d{1,}\\s*\\,\\s*-?\\d{1,}\\s*");
        String myString = sc.nextLine();
        sc.close();
        java.util.regex.Matcher myMatcher = mypattern.matcher(myString);
        ArrayList<int[]> terms = new ArrayList<>();
        while (myMatcher.find()) {
          @SuppressWarnings("resource")
          Scanner temp = new Scanner(myMatcher.group().replace(",", " "));
          terms.add(new int[] {temp.nextInt(), temp.nextInt()});
        }
        int[][] arr = new int[terms.size()][];
        for (int i = 0; i < arr.length; i++) {
          arr[i] = terms.get(i);
        }
        obj.setPolynomial(poly, arr);
        if (poly == 'A') {
          aIsSet = true;
        } else if (poly == 'B') {
          bIsSet = true;
        } else {
          cIsSet = true;
        }
        System.out.printf("Polynomial %c is set\n", poly);
        reset();
      } else if (choice == 2) {
        System.out.println("Insert the variable name : A , B or C");
        char poly;
        poly = sc.next().charAt(0);
        while ((poly == 'A' && !aIsSet) || (poly == 'B' && !bIsSet)
            || (poly == 'C' && !cIsSet)) {
          System.out.println("operand not set");
          poly = sc.next().charAt(0);
        }
        System.out.println(obj.print(poly));
        reset();
      } else if (choice == ADDCHOICE || choice == SUBTRACTCHOICE
          || choice == MULTIPLYCHOICE) {
        doOperation(choice);
      } else if (choice == EVALUATECHOICE) {
        System.out.println("Insert the variable name : A , B or C");
        char poly = sc.next().charAt(0);
        while ((poly == 'A' && !aIsSet) || (poly == 'B' && !bIsSet)
            || (poly == 'C' && !cIsSet)) {
          System.out.println("operand not set");
          poly = sc.next().charAt(0);
        }
        float varX = sc.nextFloat();
        float ans = obj.evaluatePolynomial(poly, varX);
        System.out.printf("Polynomial %c(%f) = %f \n", poly, varX, ans);
        reset();
      } else if (choice == CLEARPOLYNOMIALCHOICEC) {
        System.out.println("Insert the variable name : A , B or C");
        char poly = sc.next().charAt(0);
        while ((poly == 'A' && !aIsSet) || (poly == 'B' && !bIsSet)
            || (poly == 'C' && !cIsSet)) {
          System.out.println("operand not set");
          poly = sc.next().charAt(0);
        }
        obj.clearPolynomial(poly);
        reset();
      } else {
        throw new RuntimeException("wana zaha2t");
      }
    }
  }

  /**
   * @param choice
   *          the user choice 1 to add 2 to subtract 3 to multiply The function
   *          is responsible for addition subtraction and multiplication
   */
  static void doOperation(final int choice) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Insert the first operand variable name : A , B or C");
    char poly1 = sc.next().charAt(0);
    while ((poly1 == 'A' && !aIsSet) || (poly1 == 'B' && !bIsSet)
        || (poly1 == 'C' && !cIsSet)) {
      System.out.println("operand not set");
      poly1 = sc.next().charAt(0);
    }
    System.out.println("Insert the second operand variable name : A , B or C");
    char poly2 = sc.next().charAt(0);
    while ((poly2 == 'A' && !aIsSet) || (poly2 == 'B' && !bIsSet)
        || (poly2 == 'C' && !cIsSet)) {
      System.out.println("operand not set");
      poly2 = sc.next().charAt(0);
    }
    int[][] res;
    if (choice == ADDCHOICE) {
      res = obj.add(poly1, poly2);
    } else if (choice == SUBTRACTCHOICE) {
      res = obj.subtract(poly1, poly2);
    } else {
      res = obj.multiply(poly1, poly2);
    }
    System.out.print("Result set in R : ");
    for (int i = 0; i < res.length; i++) {
      System.out.print("(" + res[i][0] + " , " + res[i][1] + ")");
      if (i == res.length - 1) {
        System.out.println();
      } else {
        System.out.print(" , ");
      }
    }
    sc.close();
    reset();
  }

  /**
   * Prints the Menu After all operations.
   */
  static void reset() {
    System.out.println(
        "====================================================================");
    System.out.println("Please choose an action");
    System.out.println("1 - Set a polynomial variable , ... etc");
    System.out.println(
        "====================================================================");
  }
}
