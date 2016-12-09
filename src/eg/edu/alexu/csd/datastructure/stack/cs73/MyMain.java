package eg.edu.alexu.csd.datastructure.stack.cs73;

import java.util.Scanner;

/**
 * @author Mahmoud.
 */
public final class MyMain {

  /**
   * Constructor of the class.
   */
  private MyMain() {

  }

  /**
   * time to sleep after displaying the message "Exit Success".
   */
  public static final int TIMETOSLEEP = 1000;

  /**
   * The Main Method.
   * @param args
   *          the argument of the main function
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Make your choice !");
    System.out.println("1- Stack Test");
    System.out.println("2- Evaluator Application");
    System.out.println("3- Exit");
    while (true) {
      String choice = sc.nextLine();
      if (choice.toLowerCase().equals("stack test") || choice.equals("1")) {
        StackMain.stackMain();
      } else if (choice.toLowerCase().equals("evaluator application")
          || choice.equals("2")) {
        EvaluatorMain.evaluatorkMain();
      } else if (choice.toLowerCase().equals("exit") || choice.equals("3")) {
        System.out.println("Exit Success");
        try {
          System.out.println("Exit Success");
          Thread.sleep(TIMETOSLEEP);
          System.exit(0);
        } catch (InterruptedException excep) {
          excep.printStackTrace();
          break;
        }
      } else {
        System.out.println("Wrong input");
      }
    }
    sc.close();
  }
}
