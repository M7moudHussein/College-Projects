package eg.edu.alexu.csd.datastructure.calculator.cs73;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

/**
 * @author mahmoud-pc
 */
public class MyCalculator implements ICalculator {

  /**
   * @see eg.edu.alexu.csd.datastructure.calculator.ICalculator#add(int, int)
   * @param varX
   *          first operand
   * @param varY
   *          second operand
   * @return sum of varX and varY
   */
  public final int add(final int varX, final int varY) {
    return varX + varY;
  }

  /**
   * @see eg.edu.alexu.csd.datastructure.calculator.ICalculator#divide(int, int)
   * @param varX
   *          first operand
   * @param varY
   *          second operand
   * @return of varX divided by varY
   */
  public final float divide(final int varX, final int varY) {
    return (float) varX / varY;
  }

}
