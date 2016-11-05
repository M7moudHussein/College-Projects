package stack.cs73;

import java.util.Scanner;

/**
 * implementation for the UI of the stack.
 * @see {@link MyMain}
 */
public final class StackMain {

  /**
   * constructor for the Stack Class.
   */
  private StackMain() {
  }

  /**
   * Stack interface, it's a textual user interface.
   * @see Tha Main method {@link MyMain}
   */
  public static void stackMain() {
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    MyStack stack = new MyStack();
    String choice = "0";
    System.out.println("This is An Application to test a stack implementation");
    while (true) {
      printMenu();
      choice = sc.nextLine();
      if (choice.toLowerCase().equals("exit")) {
        try {
          System.out.println("Exit Success");
          Thread.sleep(MyMain.TIMETOSLEEP);
          System.exit(0);
        } catch (InterruptedException excep) {
          excep.printStackTrace();
        }
      } else if (choice.toLowerCase().equals("push") || choice.equals("1")) {
        System.out.println("Enter An element and press Enter.");
        stack.push(sc.nextLine());
        System.out.println("Element Inserted");
      } else if (choice.toLowerCase().equals("pop") || choice.equals("2")) {
        if (stack.isEmpty()) {
          System.out.println("Stack is Empty");
          continue;
        }
        System.out
            .println("Element Poped from the stack : " + (String) stack.pop());
      } else if (choice.toLowerCase().equals("peek") || choice.equals("3")) {
        if (stack.isEmpty()) {
          System.out.println("Stack is Empty");
          continue;
        }
        System.out.println("The Top of the Stack is :" + (String) stack.peek());
      } else if (choice.toLowerCase().equals("size")
          || choice.toLowerCase().equals("Get size") || choice.equals("4")) {
        System.out.println("Stack Size :" + stack.size());
      } else if (choice.toLowerCase().equals("is empty")
          || choice.equals("5")) {
        if (stack.isEmpty()) {
          System.out.println("Stack is Empty");
        } else {
          System.out.println("Stack isn't Empty");
        }
      } else {
        System.out.println("Wrong input");
      }
    }
  }

  /**
   * Prints the Menu. used in stackMain function
   */
  private static void printMenu() {
    System.out.println("\nChoose an option by its number");
    System.out.println("1- Push into Stack <you can enter Push> ");
    System.out.println("2- Pop form Stack <you can enter pop>");
    System.out.println("3- Get Peek");
    System.out.println("4- Get Size");
    System.out.println("5- Empty?");
    System.out.println("To Exit the Application Enter \"Exit\"");
    System.out.println("==================================================");

  }
}
