package eg.edu.alexu.csd.datastructure.stack.cs73;

import java.util.Scanner;

/**
 * Evaluator User interface.
 * @see {@link MyMain}
 */
public final class EvaluatorMain {
  /**
   * Class Constructor.
   */
  private EvaluatorMain() {

  }

  /**
   * evaluator interface, it's a textual user interface.
   * @see Tha Main method {@link MyMain}
   */
  public static void evaluatorkMain() {
    Scanner sc = new Scanner(System.in);
    ExpressionSolver solver = new ExpressionSolver();
    while (true) {
      System.out
          .println("Enter A numeric infix expression or \"Exit\" to exit");
      String str = sc.nextLine();
      if (str.toLowerCase().equals("exit") || str.equals("3")) {
        try {
          System.out.println("Exit Success");
          Thread.sleep(MyMain.TIMETOSLEEP);
          System.exit(0);
        } catch (InterruptedException excep) {
          excep.printStackTrace();
          break;
        }
      }
      String post;
      try {
        post = solver.infixToPostfix(str);
      } catch (Exception e) {
        System.out.println("Something went wrong");
        continue;
      }
      System.out.println("Postfix expression : " + post);
      int ans;
      try {
        ans = solver.evaluate(post);
      } catch (Exception e) {
        System.out.println("Something went wrong");
        continue;
      }
      System.out.println("Result : " + ans);
    }
    sc.close();
  }
}
