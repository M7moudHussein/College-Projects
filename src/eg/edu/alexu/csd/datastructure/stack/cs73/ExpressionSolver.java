package eg.edu.alexu.csd.datastructure.stack.cs73;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 * An Application to transform an infix expression into a postfix expression. It
 * also has the function Evaluate that Evaluates a postfix expression.
 */
public class ExpressionSolver implements IExpressionEvaluator {
  /**
   * Takes a symbolic/numeric infix expression as input and converts it to
   * postfix notation. There is no assumption on spaces between terms or the
   * length of the term (e.g., two digits symbolic or numeric term) *
   * @param myExpression
   *          infix expression
   * @return postfix expression
   */
  public final String infixToPostfix(final String myExpression) {
    MyStack operators = new MyStack();
    StringBuilder str;
    String expression = myExpression.replaceAll("\\s+", "");
    str = new StringBuilder();
    Character current;
    Character prev = '!';
    for (int i = 0; i < expression.length(); i++) {
      current = expression.charAt(i);
      if (notValid(prev, current)) {
        throw new RuntimeException("Wrong input form");
      }
      if (current.toString().matches("[/*+-]")) {
        if (i == 0 || i == expression.length() - 1) {
          throw new RuntimeException("Wrong input form");
        }
      }
      prev = current;
      if (Character.isLetterOrDigit(current)) {
        str.append(current);
      } else if (current == '(') {
        operators.push(current);
        str.append(" ");
      } else if (current == ')') {
        StringBuilder temp = new StringBuilder();
        while (true) {
          if (operators.isEmpty()) {
            throw new RuntimeException("Parentheses not matching");
          }
          if ((char) operators.peek() == '(') {
            operators.pop();
            break;
          }
          temp.append(" " + (char) operators.pop());
        }
        str.append(temp + " ");
      } else if (operators.isEmpty()
          || canPush((char) operators.peek(), current)) {
        operators.push(current);
        str.append(" ");
      } else {
        StringBuilder temp = new StringBuilder();
        while (!operators.isEmpty()) {
          if (canPush((char) operators.peek(), current)) {
            break;
          }
          temp.append(" " + (char) operators.pop());
        }
        str.append(temp + " ");
        operators.push(current);
      }
    }
    while (!operators.isEmpty()) {
      if ((char) operators.peek() == '(') {
        throw new RuntimeException("Parentheses not matching");
      }
      str.append(" " + operators.pop());
    }
    if (Character.isWhitespace(str.charAt(0))) {
      str.deleteCharAt(0);
    }
    expression = str.toString();
    expression = expression.replaceAll("\\s+", " ");
    return expression;
  }

  /**
   * Checks if it's available to push the current operator in the stack.
   * @param top
   *          the Top operator in the stack
   * @param current
   *          selected operator in the expression
   * @return true if it's available to push the new operator in the stack else
   *         false
   */
  private boolean canPush(final char top, final char current) {
    if (top == '('
        || ((top == '-' || top == '+') && (current == '*' || current == '/'))) {
      return true;
    }
    return false;
  }

  /**
   * To validate the expression.
   * @param op1
   *          previous character
   * @param op2
   *          the current character
   * @return True if the expression is not valid else fasle
   */
  private boolean notValid(final char op1, final char op2) {
    if ((op1 == '(' && op2 == ')') || (op1 == ')' && op2 == '(')) {
      return true;
    } else if ((op1 == '+' || op1 == '*' || op1 == '-' || op1 == '/')
        && (op2 == '+' || op2 == '*' || op2 == '-' || op2 == '/')) {
      return true;
    }
    return false;
  }

  /**
   * Evaluate a postfix numeric expression, with a single space separator.
   * @param myExpression
   *          postfix expression
   * @return the expression evaluated value
   */
  public final int evaluate(final String myExpression) {
    MyStack evaluator = new MyStack();
    StringBuilder var = new StringBuilder();
    String expression = myExpression.replace("\\s+", " ");
    if (Character.isWhitespace(expression.charAt(0))) {
      expression = expression.substring(1);
    }
    expression = expression + " ";
    Character current;
    for (int i = 0; i < expression.length(); i++) {
      current = expression.charAt(i);
      if (Character.isWhitespace(current)) {
        continue;
      }
      if (Character.isDigit(current)) {
        while (Character.isDigit(current) && i < expression.length()) {
          var.append(current);
          i++;
          current = expression.charAt(i);
        }
        evaluator.push(Double.valueOf(var.toString()));
        var.setLength(0);
      }
      if (current.toString().matches("[/*+-]")) {
        if (evaluator.size() < 2) {
          throw new RuntimeException("Wrong formula");
        }
        double varY = (double) evaluator.pop();
        double varX = (double) evaluator.pop();
        evaluator.push(new Double(calculate(varX, varY, current)));
      }
    }
    if (evaluator.size() != 1) {
      throw new RuntimeException("Wrong formula");
    }
    return ((Double) evaluator.pop()).intValue();
  }

  /**
   * Used in function Evaluate.
   * @param varX
   *          the left operand of the expression
   * @param varY
   *          the right operand of the expression
   * @param op
   *          a character that represents the operator
   * @return the result of the expression
   */
  private double calculate(final double varX, final double varY,
      final char op) {
    if (op == '+') {
      return varX + varY;
    } else if (op == '-') {
      return varX - varY;
    } else if (op == '*') {
      return varX * varY;
    } else {
      return varX / varY;
    }
  }
}
